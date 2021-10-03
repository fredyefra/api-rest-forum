package br.com.estudo.forum.exception

import br.com.estudo.forum.dto.ErrorView
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest

@RestControllerAdvice
class ExceptionHandler {

  @ExceptionHandler(LancarNotFoundException::class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  fun handlerNotFound(exception:LancarNotFoundException,
       request:HttpServletRequest): ErrorView {
    return ErrorView(
      status = HttpStatus.NOT_FOUND.value(),
      error =  HttpStatus.NOT_FOUND.name,
      message = exception.message,
      path = request.servletPath
    )
  }

  @ExceptionHandler(Exception::class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  fun handlerServerError(exception:Exception,
                      request:HttpServletRequest): ErrorView {
    return ErrorView(
      status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
      error =  HttpStatus.INTERNAL_SERVER_ERROR.name,
      message = exception.message,
      path = request.servletPath
    )
  }

}