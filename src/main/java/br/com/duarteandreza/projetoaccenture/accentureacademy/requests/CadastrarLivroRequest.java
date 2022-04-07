package br.com.duarteandreza.projetoaccenture.accentureacademy.requests;

import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.Clientes;
import br.com.duarteandreza.projetoaccenture.accentureacademy.domain.TipoLacamentoCaixa;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CadastrarLivroRequest {

    private Long idcliente;
    private LocalDate dataLancamento;
    @NotBlank
    private String descricao;
    @Valid
    private TipoLacamentoCaixa tipoLacamentoCaixa;
    @NotNull
    private BigDecimal valor;

}
