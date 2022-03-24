package br.com.duarteandreza.projetoaccenture.accentureacademy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoLacamentoCaixa {

    D("Débito"),
    C("Crédito");

    private String descricao;

}
