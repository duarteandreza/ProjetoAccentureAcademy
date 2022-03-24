package br.com.duarteandreza.projetoaccenture.accentureacademy.requests;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.PerfilUsuario;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlterarDadosUsuarioRequest {

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
    @Valid
    private PerfilUsuario perfilUsuario;

}
