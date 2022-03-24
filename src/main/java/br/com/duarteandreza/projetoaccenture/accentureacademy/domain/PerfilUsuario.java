package br.com.duarteandreza.projetoaccenture.accentureacademy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PerfilUsuario {

    A("Administrador"),
    O("Operador");

    private String descricao;

}
