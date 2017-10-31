package com.park9eon.spark.config

import com.park9eon.spark.logger.EmbeddedJettyFactoryConstructor
import com.park9eon.spark.logger.RequestLogFactory
import org.apache.log4j.BasicConfigurator
import org.apache.log4j.Logger
import spark.embeddedserver.EmbeddedServers
import spark.embeddedserver.jetty.EmbeddedJettyFactory


/**
 * Initial version by: park9eon
 * Initial version created on: 30/10/2017
 */

fun createServerWithRequestLog(logger: Logger) {
    val factory = createEmbeddedJettyFactoryWithRequestLog(logger)
    EmbeddedServers.add(EmbeddedServers.Identifiers.JETTY, factory)
    BasicConfigurator.configure()
}

fun createEmbeddedJettyFactoryWithRequestLog(logger: Logger): EmbeddedJettyFactory {
    val requestLog = RequestLogFactory(logger).create()
    return EmbeddedJettyFactoryConstructor(requestLog).create()
}