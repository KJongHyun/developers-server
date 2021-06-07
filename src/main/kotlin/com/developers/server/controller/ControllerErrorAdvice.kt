package com.developers.server.controller

import com.developers.server.CmLogger
import com.developers.server.exception.CommunityException
import com.developers.server.exception.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ControllerErrorAdvice {
    companion object : CmLogger

    @ExceptionHandler(CommunityException::class)
    fun customError(request: HttpServletRequest, e: CommunityException): ResponseEntity<ErrorResponse> {
        log.error("${request.method}, ${request.requestURL}")
        return ResponseEntity.status(e.errorCode.httpStatus).body(ErrorResponse(e.errorCode))
    }
}