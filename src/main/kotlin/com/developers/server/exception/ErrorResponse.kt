package com.developers.server.exception

data class ErrorResponse(
    val errorCode: String,
    val errorMessage: String
) {
    constructor(errorCode: ErrorCode) : this(errorCode.name, errorCode.description)
}
