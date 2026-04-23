package com.net.atividade2.dto.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record EnderecoDTORequest(

        @NotBlank(message = "Rua não pode estar vazia")
        String rua,

        @Pattern(regexp = "^[0-9]+$", message = "Pode ser apenas número")
        @NotBlank(message = "O número não pode estar vazio")
        String numero
) {
}
