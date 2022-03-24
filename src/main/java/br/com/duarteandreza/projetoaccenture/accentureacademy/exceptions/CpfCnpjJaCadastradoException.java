package br.com.duarteandreza.projetoaccenture.accentureacademy.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CpfCnpjJaCadastradoException extends RuntimeException {
    public CpfCnpjJaCadastradoException(String cpfCnpjInformado) {
        super(String.format("Já existe um recurso com cpf/cnpj com o valor '%s'.", cpfCnpjInformado));
    }
}
