package br.com.duarteandreza.projetoaccenture.accentureacademy.requests;


import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.TipoLacamentoCaixa;
import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlterarDadosLivroRequest {

    @NotBlank(message = "O campo 'Descrição' é obrigatório.")
    private String descricao;
    @NotBlank(message = "O campo 'Tipo Lançamento' é obrigatório.")
    private TipoLacamentoCaixa tipoLacamentoCaixa;
    private BigDecimal valor;

}
