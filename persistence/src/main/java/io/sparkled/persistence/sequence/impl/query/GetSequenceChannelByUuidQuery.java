package io.sparkled.persistence.sequence.impl.query;

import io.sparkled.model.entity.SequenceChannel;
import io.sparkled.persistence.PersistenceQuery;
import io.sparkled.persistence.QueryFactory;

import java.util.Optional;
import java.util.UUID;

public class GetSequenceChannelByUuidQuery implements PersistenceQuery<Optional<SequenceChannel>> {

    private final int sequenceId;
    private final UUID channelUuid;

    public GetSequenceChannelByUuidQuery(int sequenceId, UUID channelUuid) {
        this.sequenceId = sequenceId;
        this.channelUuid = channelUuid;
    }

    @Override
    public Optional<SequenceChannel> perform(QueryFactory queryFactory) {
        SequenceChannel sequenceChannel = queryFactory
                .selectFrom(qSequenceChannel)
                .where(qSequenceChannel.uuid.eq(channelUuid).and(qSequenceChannel.sequenceId.eq(sequenceId)))
                .fetchFirst();

        return Optional.ofNullable(sequenceChannel);
    }
}