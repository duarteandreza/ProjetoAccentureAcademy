package br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotNull;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class IdNaoEncontradaException extends RuntimeException {
    public IdNaoEncontradaException(@NotNull Long idInformado) {
        super(String.format("Nenhum Id com o valor '%s' foi encontrado.", idInformado));
    }
}
