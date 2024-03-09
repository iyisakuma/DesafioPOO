package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Conteudo extends TableDB{

    @Transient
    protected static final BigDecimal XP_PADRAO = BigDecimal.TEN;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titulo;
    private LocalDate dtFinalizado;

}
