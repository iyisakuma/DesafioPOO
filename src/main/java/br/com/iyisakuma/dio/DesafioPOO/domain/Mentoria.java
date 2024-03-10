package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
public class Mentoria extends Conteudo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private LocalDate data;

    @Override
    public BigDecimal getXp() {
        return XP_PADRAO.add(new BigDecimal(20));
    }
}
