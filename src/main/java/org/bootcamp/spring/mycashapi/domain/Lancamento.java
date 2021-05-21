package org.bootcamp.spring.mycashapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "lancamento")
public class Lancamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(length = 100)
    @NotBlank(message = "Campo Descrição é obrigatório")
    @Size(max = 100, message = "Máximo de 100 caracteres")
    private String descricao;

    @NotNull(message = "Campo Data é obrigatório")
    private LocalDate data;

    @Column(precision = 8, scale = 2)
    @Min(value = 0, message = "Informe um valor")
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    @NotNull(message = "Campo Tipo é obrigatório")
    private LancamentoTipo tipo;

}