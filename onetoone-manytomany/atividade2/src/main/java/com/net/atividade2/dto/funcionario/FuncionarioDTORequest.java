package com.net.atividade2.dto.funcionario;

import com.net.atividade2.dto.endereco.EnderecoDTORequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

public record FuncionarioDTORequest(

        @NotBlank
        String nome,

        @Valid
        EnderecoDTORequest endereco
) {
}
