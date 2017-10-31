package com.park9eon.spark

import com.park9eon.spark.config.createServerWithRequestLog
import org.apache.log4j.Logger
import spark.Spark.get


/**
 * Initial version by: park9eon
 * Initial version created on: 30/10/2017
 */
fun main (vararg args: String) {
    val logger = Logger.getLogger("app")
    createServerWithRequestLog(logger)
    get("/") { req, res ->
        "Hello, Spark"
    }
}
