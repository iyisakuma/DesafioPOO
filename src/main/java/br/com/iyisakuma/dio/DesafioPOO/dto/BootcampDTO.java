package br.com.iyisakuma.dio.DesafioPOO.dto;

import br.com.iyisakuma.dio.DesafioPOO.domain.Conteudo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BootcampDTO(
        @NotNull(message = "Preencha descrição")
        @NotBlank
        String descricao
) {
}
