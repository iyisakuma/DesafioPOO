package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Data
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Conteudo extends TableDB{

    @Transient
    protected static final BigDecimal XP_PADRAO = BigDecimal.TEN;

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    protected long id;
    protected String titulo;
    public abstract BigDecimal getXp();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conteudo conteudo = (Conteudo) o;
        return id == conteudo.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
