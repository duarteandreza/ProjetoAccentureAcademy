package br.com.duarteandreza.projetoaccenture.accentureacademy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo 'Data de Cadastro' é obrigatório.")
    private LocalDate dataCadastro;
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    @Column(length = 30)
    private String nome;
    @NotBlank(message = "O campo 'CPF/CNPJ' é obrigatório.")
    @Pattern(regexp= "([0-9]{11,14})", message = "O CPF/CNPJ deve ser informado sem pontos e traços.")
    @Column (length = 14)
    private String cpfCnpj;
    @NotBlank(message = "O campo 'Logradouro' é obrigatório.")
    @Column (length = 50)
    private String logradouro;
    @NotBlank(message = "O campo 'Cidade' é obrigatório.")
    @Column (length = 40)
    private String cidade;
    @NotBlank(message = "O campo 'UF' é obrigatório.")
    @Column (length = 2)
    private String uf;
    @NotBlank(message = "O campo 'CEP' é obrigatório.")
    @Column (length = 8)
    private String cep;
    @Column (length = 11)
    private String telefone;
    @Column (length = 100)
    private String email;

}
