package io.sparkled.viewmodel.sequence.channel

import io.sparkled.model.animation.SequenceChannelEffects
import io.sparkled.model.entity.SequenceChannel
import io.sparkled.model.util.GsonProvider
import io.sparkled.persistence.sequence.SequencePersistenceService
import javax.inject.Inject

class SequenceChannelViewModelConverterImpl
@Inject constructor(private val sequencePersistenceService: SequencePersistenceService) :
    SequenceChannelViewModelConverter() {

    override fun toViewModel(model: SequenceChannel): SequenceChannelViewModel {
        val channelJson = model.getChannelJson()
        val sequenceChannelEffects = GsonProvider.get().fromJson(channelJson, SequenceChannelEffects::class.java)

        return SequenceChannelViewModel()
            .setUuid(model.getUuid())
            .setSequenceId(model.getSequenceId())
            .setStagePropUuid(model.getStagePropUuid())
            .setName(model.getName())
            .setDisplayOrder(model.getDisplayOrder())
            .setEffects(sequenceChannelEffects.effects)
    }

    override fun toModel(viewModel: SequenceChannelViewModel): SequenceChannel {
        val model = sequencePersistenceService
            .getSequenceChannelByUuid(viewModel.getSequenceId()!!, viewModel.getUuid()!!)
            ?: SequenceChannel()

        val channelJson = GsonProvider.get().toJson(SequenceChannelEffects(viewModel.getEffects()))
        return model
            .setUuid(viewModel.getUuid())
            .setSequenceId(viewModel.getSequenceId())
            .setStagePropUuid(viewModel.getStagePropUuid())
            .setName(viewModel.getName())
            .setDisplayOrder(viewModel.getDisplayOrder())
            .setChannelJson(channelJson)
    }
}
