package com.net.atividade1.dto.pessoa;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PessoaDTORequest(

        @NotBlank
        String nome,

        @Positive
        @NotNull
        Long documento_id
) {
}
