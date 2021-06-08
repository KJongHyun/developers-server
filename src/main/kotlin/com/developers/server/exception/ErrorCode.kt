package com.developers.server.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(val httpStatus: Int, val description: String) {
    DATA_NOT_FOUND(HttpStatus.BAD_REQUEST.value(), "존재하지 않는 데이터 입니다."),
    ETC_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "ETC ERROR")
}