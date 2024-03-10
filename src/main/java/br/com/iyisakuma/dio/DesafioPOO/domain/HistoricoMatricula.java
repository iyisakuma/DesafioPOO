package br.com.iyisakuma.dio.DesafioPOO.domain;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
public class HistoricoMatricula extends TableDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Conteudo conteudo;
    private LocalDate dtInicio = LocalDate.now();
    private LocalDate dtFinalizado;
}
