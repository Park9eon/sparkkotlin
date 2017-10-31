package com.park9eon.spark.logger

import org.apache.log4j.Logger
import java.io.IOException
import org.eclipse.jetty.server.AbstractNCSARequestLog


/**
 * Initial version by: park9eon
 * Initial version created on: 30/10/2017
 */

class RequestLogFactory(private val logger: Logger) {

    internal fun create(): AbstractNCSARequestLog {
        return object : AbstractNCSARequestLog() {
            override fun isEnabled(): Boolean {
                return true
            }

            @Throws(IOException::class)
            override fun write(s: String) {
                logger.info(s)
            }
        }
    }
}