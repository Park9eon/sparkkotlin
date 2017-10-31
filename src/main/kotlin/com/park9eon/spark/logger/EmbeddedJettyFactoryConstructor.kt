package com.park9eon.spark.logger

import org.eclipse.jetty.util.thread.QueuedThreadPool
import spark.embeddedserver.jetty.EmbeddedJettyFactory
import org.eclipse.jetty.server.AbstractNCSARequestLog
import org.eclipse.jetty.server.Server

/**
 * Initial version by: park9eon
 * Initial version created on: 30/10/2017
 */
class EmbeddedJettyFactoryConstructor(private var requestLog: AbstractNCSARequestLog) {
    internal fun create(): EmbeddedJettyFactory {
        return EmbeddedJettyFactory { maxThreads, minThreads, threadTimeoutMillis ->
            val server: Server
            server = if (maxThreads > 0) {
                val max = if (maxThreads > 0) maxThreads else 200
                val min = if (minThreads > 0) minThreads else 8
                val idleTimeout: Int = if (threadTimeoutMillis > 0) threadTimeoutMillis else '\uea60'.toInt()
                Server(QueuedThreadPool(max, min, idleTimeout))
            } else {
                Server()
            }
            server.requestLog = requestLog
            server
        }
    }
}