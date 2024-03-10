package br.com.iyisakuma.dio.DesafioPOO.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public record MentoriaDto(
        @JsonFormat(pattern = "dd/MM/yyyy")
        LocalDate date,
        String titulo,
        String descricao
) {
}
