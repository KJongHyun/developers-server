package com.developers.server.exception

import org.springframework.http.HttpStatus

enum class ErrorCode(val httpStatus: Int, val description: String) {
    NOT_EXIST_POST(HttpStatus.BAD_REQUEST.value(), "존재하지 않는 게시글 입니다.")
}