package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Curso extends Conteudo {

    private int cargaHoraria;


    @Override
    public BigDecimal getXp() {
        return XP_PADRAO.multiply(new BigDecimal(cargaHoraria));
    }
}
