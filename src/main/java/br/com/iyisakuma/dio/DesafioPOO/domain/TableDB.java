package br.com.iyisakuma.dio.DesafioPOO.domain;


import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public abstract class TableDB {

    @Column(insertable = false, updatable = false)
    private LocalDate dtCreate = LocalDate.now();
    private LocalDate dtUpdate = LocalDate.now();
}
