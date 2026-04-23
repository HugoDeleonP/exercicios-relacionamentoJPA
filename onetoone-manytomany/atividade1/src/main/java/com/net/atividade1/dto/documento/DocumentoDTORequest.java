package com.net.atividade1.dto.documento;

import jakarta.validation.constraints.NotBlank;

public record DocumentoDTORequest(

        @NotBlank
        String numero,

        @NotBlank
        String tipo
) {
}
