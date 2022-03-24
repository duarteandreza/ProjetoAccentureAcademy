package br.com.duarteandreza.projetoaccenture.accentureacademy.domain;

//import lombok.*;
//
//import javax.persistence.*;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.NotNull;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Entity
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class LivroCaixa {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
//    private Clientes idCliente;
//    @NotNull(message = "O campo 'Data de Lançamento' é obrigatório.")
//    private LocalDate dataLancamento;
//    @NotBlank(message = "O campo 'Descrição' é obrigatório.")
//    private String descricao;
//    @Enumerated(EnumType.STRING)
//    @NotBlank(message = "O campo 'Tipo' é obrigatório.")
//    private TipoLacamentoCaixa tipoLacamentoCaixa;
//    private BigDecimal valor;
//
//}
