package com.example.kotlinjournal.exception

// в контроллере вылетит 500ка, можно использовать @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "resource not found")
// или advice controller
class ElementNotFoundException(message: String) : RuntimeException(message)