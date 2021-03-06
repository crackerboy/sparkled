package io.sparkled.persistence.sequence.impl.query

import io.sparkled.model.entity.QRenderedStageProp.renderedStageProp
import io.sparkled.model.entity.RenderedStageProp
import io.sparkled.model.entity.Sequence
import io.sparkled.model.render.RenderedStagePropDataMap
import io.sparkled.model.util.IdUtils.NO_UUIDS
import io.sparkled.model.util.TupleUtils
import io.sparkled.persistence.PersistenceQuery
import io.sparkled.persistence.QueryFactory
import io.sparkled.persistence.stage.impl.query.DeleteRenderedStagePropsQuery
import org.slf4j.LoggerFactory
import java.util.UUID

class SaveRenderedStagePropsQuery(
    private val sequence: Sequence,
    private val renderedStagePropDataMap: RenderedStagePropDataMap
) : PersistenceQuery<Unit> {

    override fun perform(queryFactory: QueryFactory) {
        val entityManager = queryFactory.entityManager

        // The stage prop IDs must be set, or new records will be created instead of updating existing records.
        val renderedStagePropIds = getRenderedStagePropIds(queryFactory)

        renderedStagePropDataMap.forEach { key, value ->
            val renderedStageProp = RenderedStageProp()
                .setId(renderedStagePropIds[key])
                .setSequenceId(sequence.getId())
                .setStagePropUuid(key)
                .setLedCount(value.ledCount)
                .setData(value.data)
            entityManager.merge(renderedStageProp)
        }

        logger.info("Saved {} rendered stage prop(s) for sequence {}.", renderedStagePropDataMap.size, sequence.getId())

        deleteRemovedRenderedStageProps(queryFactory, sequence, renderedStagePropDataMap.keys)
    }

    private fun getRenderedStagePropIds(queryFactory: QueryFactory): Map<UUID, Int> {
        val stagePropUuids = renderedStagePropDataMap.keys
        return queryFactory
            .select(renderedStageProp.stagePropUuid, renderedStageProp.id)
            .from(renderedStageProp)
            .where(renderedStageProp.sequenceId.eq(sequence.getId()).and(renderedStageProp.stagePropUuid.`in`(stagePropUuids)))
            .fetch()
            .associateBy(
                { tuple -> tuple.get(0, UUID::class.java)!! },
                { tuple -> TupleUtils.getInt(tuple, 1) }
            )
    }

    private fun deleteRemovedRenderedStageProps(
        queryFactory: QueryFactory,
        sequence: Sequence,
        uuidsToKeep: Collection<UUID>
    ) {
        val uuids = if (uuidsToKeep.isEmpty()) NO_UUIDS else uuidsToKeep

        val idsToDelete = queryFactory
            .select(renderedStageProp.id)
            .from(renderedStageProp)
            .where(renderedStageProp.sequenceId.eq(sequence.getId()).and(renderedStageProp.stagePropUuid.notIn(uuids)))
            .fetch()

        DeleteRenderedStagePropsQuery(idsToDelete).perform(queryFactory)
    }

    companion object {
        private val logger = LoggerFactory.getLogger(SaveRenderedStagePropsQuery::class.java)
    }
}
