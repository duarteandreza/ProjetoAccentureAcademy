package br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailJaCadastradoException extends RuntimeException {
    public EmailJaCadastradoException(String emailInformado) {
        super(String.format("Já existe um recurso do tipo Usuario com E-mail com o valor '%s'.", emailInformado));
    }
}
