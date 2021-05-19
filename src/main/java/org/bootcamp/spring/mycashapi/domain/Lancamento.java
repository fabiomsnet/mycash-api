package org.bootcamp.spring.mycashapi.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
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

    @Column(name = "ds_descricao", length = 100)
    private String descricao;

    @Column(name = "dt_data", nullable = false)
    private LocalDate data;

    @Column(name = "vl_valor", precision = 8, scale = 2)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private LancamentoTipo tipo;

}