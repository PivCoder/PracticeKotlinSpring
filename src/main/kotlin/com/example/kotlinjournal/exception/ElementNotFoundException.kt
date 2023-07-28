package com.example.kotlinjournal.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found")
class ElementNotFoundException(message: String) : RuntimeException(message)