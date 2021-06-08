package com.developers.server.exception

class CommunityException(val errorCode: ErrorCode, errorMessage: String) : RuntimeException(errorMessage) {
    constructor(errorCode: ErrorCode) : this(errorCode, errorCode.description)
}