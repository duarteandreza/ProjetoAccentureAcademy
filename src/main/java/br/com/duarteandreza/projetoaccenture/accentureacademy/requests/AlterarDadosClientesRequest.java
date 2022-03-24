package br.com.duarteandreza.projetoaccenture.accentureacademy.requests;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlterarDadosClientesRequest {

    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String nome;
    @NotBlank (message = "O campo 'Logradouro' é obrigatório.")
    private String logradouro;
    @NotBlank (message = "O campo 'Cidade' é obrigatório.")
    private String cidade;
    @NotBlank (message = "O campo 'UF' é obrigatório.")
    private String uf;
    @NotBlank (message = "O campo 'CEP' é obrigatório.")
    private String cep;
    private String telefone;
    private String email;

}
