package com.developers.server

import org.slf4j.LoggerFactory

interface Logger {
    val log
    get() = LoggerFactory.getLogger(this.javaClass)
}