package com.net.empresa.dto.funcionario;

import java.time.LocalDate;

public record FuncionarioDTOResponse(
        Long id,
        String nome,

        LocalDate dataNascimento,
        String departamentoNome
) {
}
