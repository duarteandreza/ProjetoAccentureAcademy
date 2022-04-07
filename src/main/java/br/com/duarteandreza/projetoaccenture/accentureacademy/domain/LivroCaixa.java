package br.com.duarteandreza.projetoaccenture.accentureacademy.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LivroCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_cliente")
    private Clientes cliente;
    @NotNull(message = "O campo 'Data de Lançamento' é obrigatório.")
    private LocalDate dataLancamento;
    @NotBlank(message = "O campo 'Descrição' é obrigatório.")
    @Column (length = 50)
    private String descricao;
    @Enumerated(EnumType.STRING)
    @NotBlank(message = "O campo 'Tipo' é obrigatório.")
    @Column (length = 1)
    private TipoLacamentoCaixa tipoLacamentoCaixa;
    @Column (length = 12)
    private BigDecimal valor;

}
