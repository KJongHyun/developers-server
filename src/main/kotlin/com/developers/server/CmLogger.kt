package com.developers.server

import org.slf4j.Logger
import org.slf4j.LoggerFactory

interface CmLogger {
    val log: Logger get() = LoggerFactory.getLogger(this.javaClass)
}