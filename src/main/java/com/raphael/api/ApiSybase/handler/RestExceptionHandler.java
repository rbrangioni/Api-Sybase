package com.raphael.api.ApiSybase.handler;

import com.raphael.api.ApiSybase.error.ResourceNotFoundDetails;
import com.raphael.api.ApiSybase.error.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.OffsetDateTime;
import java.util.Date;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException){
        ResourceNotFoundDetails resourceNotFoundDetails = ResourceNotFoundDetails.Builder
                .newBuiler()
                .timestamp(new String(String.valueOf(OffsetDateTime.now())))
                .status(HttpStatus.NOT_FOUND.value())
                .titulo("Recurso Não encontrado")
                .detalhe(resourceNotFoundException.getMessage())
                .mensagem(resourceNotFoundException.getClass().getName())
                .build();

        return new ResponseEntity<>(resourceNotFoundDetails, HttpStatus.NOT_FOUND);

    }
}
