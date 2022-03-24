package br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class LoginJaCadastradoException extends RuntimeException {
    public LoginJaCadastradoException(String loginInformado) {
        super(String.format("Já existe um recurso do tipo Usuario com Login com o valor '%s'.", loginInformado));
    }
}
