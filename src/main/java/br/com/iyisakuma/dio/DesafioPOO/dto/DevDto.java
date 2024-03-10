package br.com.iyisakuma.dio.DesafioPOO.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DevDto(
        @NotNull
        @NotBlank
        String nome
) {
}
