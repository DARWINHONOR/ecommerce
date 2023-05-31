package com.et.ecommerce.exception;

import com.et.ecommerce.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
  @ExceptionHandler(RoleAlreadyExists.class)
  public ResponseEntity<ErrorResponseDto> resourceAlreadyException(RoleAlreadyExists ex) {
    ErrorResponseDto message = new ErrorResponseDto();
    message.setStatus(HttpStatus.CONFLICT.value());
    message.setError(ex.toString());
    message.setMessage(ex.getMessage());

    return new ResponseEntity<ErrorResponseDto>(message, HttpStatus.CONFLICT);
  }
}
