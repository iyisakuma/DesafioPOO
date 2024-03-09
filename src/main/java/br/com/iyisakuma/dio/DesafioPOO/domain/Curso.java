package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Curso extends Conteudo {

    private int cargaHoraria;

}
