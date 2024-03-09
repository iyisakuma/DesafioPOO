package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
public class Curso extends Conteudo {

    private int cargaHoraria;



}
