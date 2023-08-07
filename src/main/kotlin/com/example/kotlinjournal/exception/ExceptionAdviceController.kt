package com.example.kotlinjournal.exception

import org.springframework.http.HttpStatus
import org.springframework.http.ProblemDetail
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@ControllerAdvice
class ExceptionAdviceController : ResponseEntityExceptionHandler() {
    @ExceptionHandler(ElementNotFoundException::class)
    fun handleEntityNotFoundException(ex: ElementNotFoundException): ResponseEntity<ProblemDetail> {
        val problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, "This page not found :)")
        return ResponseEntity(problemDetail, HttpStatus.NOT_FOUND)
    }
}