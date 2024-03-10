package br.com.iyisakuma.dio.DesafioPOO.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record CursoDTO(
        @NotNull(message = "Informe o título do curso!" )
        @NotBlank(message = "O titulo não pode está em branco!")
        String titulo,
        @NotNull(message = "Informe a descrição do curso!")
        @NotBlank(message = "A descrição do curso não pode está em branco!") String descricao,
        @NotNull(message = "Informe a carga horária do curso!")
        @Positive(message = "A carga horária precisa ser um número maior que zero!")
        int cargaHoraria) {
}
