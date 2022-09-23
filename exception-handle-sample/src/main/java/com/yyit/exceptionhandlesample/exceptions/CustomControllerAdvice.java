package com.yyit.exceptionhandlesample.exceptions;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomControllerAdvice {

  @ExceptionHandler(NullPointerException.class) // exception handled
  public ResponseEntity<ErrorResponse> handleNullPointerExceptions(Exception e) {
    // ... potential custom logic

    HttpStatus status = HttpStatus.NOT_FOUND; // 404

    return new ResponseEntity<>(
        new ErrorResponse(
            status,
            e.getMessage()),
        status);
  }

  @ExceptionHandler(Exception.class) // exception handled
  public ResponseEntity<ErrorResponse> handleExceptions(Exception e) {
    // ... potential custom logic

    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR; // 500

    // converting the stack trace to String

    StringWriter stringWriter = new StringWriter();

    PrintWriter printWriter = new PrintWriter(stringWriter);

    e.printStackTrace(printWriter);
    String stackTrace = stringWriter.toString();

    return new ResponseEntity<>(
        new ErrorResponse(
            status,
            e.getMessage(),
            stackTrace // specifying the stack trace in case of 500s
        ),
        status);

  }

  @ExceptionHandler(CustomDataNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleCustomDataNotFoundExceptions(Exception e) {
    HttpStatus status = HttpStatus.NOT_FOUND; // 404
    // converting the stack trace to String
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    e.printStackTrace(printWriter);
    String stackTrace = stringWriter.toString();

    return new ResponseEntity<ErrorResponse>(new ErrorResponse(status, e.getMessage(), stackTrace), status);
  }

  @ExceptionHandler(CustomParameterConstraintException.class)
  public ResponseEntity<ErrorResponse> handleCustomParameterConstraintExceptions(
      Exception e) {
    HttpStatus status = HttpStatus.BAD_REQUEST; // 400

    return new ResponseEntity<>(
        new ErrorResponse(
            status,
            e.getMessage()),
        status);
  }

  @ExceptionHandler(CustomErrorException.class)
  public ResponseEntity<ErrorResponse> handleCustomErrorExceptions(
      Exception e) {
    // casting the generic Exception e to CustomErrorException
    CustomErrorException customErrorException = (CustomErrorException) e;

    HttpStatus status = customErrorException.getStatus();

    // converting the stack trace to String
    StringWriter stringWriter = new StringWriter();
    PrintWriter printWriter = new PrintWriter(stringWriter);
    customErrorException.printStackTrace(printWriter);
    String stackTrace = stringWriter.toString();

    return new ResponseEntity<>(
        new ErrorResponse(
            status,
            customErrorException.getMessage(),
            stackTrace,
            customErrorException.getData()),
        status);
  }

}
