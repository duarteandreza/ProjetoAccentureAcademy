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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull(message = "O campo 'Data de Cadastro' é obrigatório.")
    private LocalDate dataCadastro;
    @NotBlank(message = "O campo 'Nome' é obrigatório.")
    @Column (length = 30)
    private String nome;
    @NotBlank (message = "O campo 'Login' é obrigatório.")
    @Column (length = 15)
    private String login;
    @NotBlank (message = "O campo 'Senha' é obrigatório.")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Column (length = 10)
    private String senha;
    @Column (length = 11)
    private String telefone;
    @Column (length = 100)
    private String email;
    @Enumerated(EnumType.STRING)
    @NotBlank (message = "O campo 'Perfil' é obrigatório.")
    @Column (length = 1)
    private PerfilUsuario perfilUsuario;
    private Boolean ativo = true;

}
