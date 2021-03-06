package io.sparkled

import com.google.inject.persist.PersistService
import io.sparkled.rest.RestApiServer
import io.sparkled.scheduler.SchedulerService
import io.sparkled.schema.SchemaUpdater
import io.sparkled.udpserver.UdpServer

import javax.inject.Inject

class App
@Inject constructor(
    private val persistService: PersistService,
    private val schemaUpdater: SchemaUpdater,
    private val restApiServer: RestApiServer,
    private val udpServer: UdpServer,
    private val schedulerService: SchedulerService
) {
    internal fun start(settings: AppSettings) {
        persistService.start()
        schemaUpdater.update()
        restApiServer.start(settings.restApiPort)
        udpServer.start(settings.udpPort)
        schedulerService.start()
    }
}
