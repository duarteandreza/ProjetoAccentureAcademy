package br.com.duarteandreza.projetoaccenture.accentureacademy.controllers.exceptions;

import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoJaExisteException;
import br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions.ObjetoNaoEncontradoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ObjetoNaoEncontradoException.class)
    public ResponseEntity<StandardError> objetoNaoEncontrado(ObjetoNaoEncontradoException exception, HttpServletRequest request) {

        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), exception.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);

    }

    @ExceptionHandler(ObjetoJaExisteException.class)
    public ResponseEntity<StandardError>objetoJaExiste(ObjetoJaExisteException exception, HttpServletRequest request) {

        StandardError error = new StandardError(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), exception.getMessage(),
                request.getRequestURI());

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }


}
