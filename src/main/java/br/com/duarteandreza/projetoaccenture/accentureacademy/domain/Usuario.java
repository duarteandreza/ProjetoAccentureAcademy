package br.com.duarteandreza.projetoaccenture.accentureacademy.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo 'Data de Cadastro' é obrigatório.")
    private LocalDate dataCadastro;
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    private String nome;
    @NotBlank (message = "O campo 'Login' é obrigatório.")
    private String login;
    @NotBlank (message = "O campo 'Senha' é obrigatório.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private String telefone;
    private String email;
    @Enumerated(EnumType.STRING)
    @NotBlank (message = "O campo 'Perfil' é obrigatório.")
    private PerfilUsuario perfilUsuario;
    private Boolean ativo = true;

}
