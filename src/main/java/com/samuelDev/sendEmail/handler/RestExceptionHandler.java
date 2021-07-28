package com.samuelDev.sendEmail.handler;

import com.samuelDev.sendEmail.exceptions.BadRequestException;
import com.samuelDev.sendEmail.exceptions.BadRequestExceptionDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<BadRequestExceptionDetails> handlerBadRequestException(BadRequestException bre) {
        return new ResponseEntity<>(BadRequestExceptionDetails.builder()
                .title("Bad Request exception, check the email")
                .details("Occurrence some error in write the email, check the email details and refactor this")
                .status(HttpStatus.BAD_REQUEST.value())
                .timestamp(LocalDateTime.now())
                .developerMessage(bre.getClass().getName())
                .build(), HttpStatus.BAD_REQUEST);
    }
}
