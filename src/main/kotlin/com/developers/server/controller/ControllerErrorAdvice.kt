package com.developers.server.controller

import com.developers.server.CmLogger
import com.developers.server.exception.CommunityException
import com.developers.server.exception.ErrorCode
import com.developers.server.exception.ErrorResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ControllerErrorAdvice {
    companion object : CmLogger

    @ExceptionHandler(CommunityException::class)
    fun customError(request: HttpServletRequest, e: CommunityException): ResponseEntity<ErrorResponse> {
        log.error("${request.method}, ${request.requestURL}", e)
        return ResponseEntity.status(e.errorCode.httpStatus).body(ErrorResponse(e.errorCode))
    }

    @ExceptionHandler(Exception::class)
    fun etcException(e: Exception): ResponseEntity<ErrorResponse> {
        log.error("etc error", e)
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorResponse(ErrorCode.ETC_ERROR))
    }
}