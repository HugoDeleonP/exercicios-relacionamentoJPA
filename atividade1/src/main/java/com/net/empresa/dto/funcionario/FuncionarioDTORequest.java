package com.net.empresa.dto.funcionario;

import java.time.LocalDate;

public record FuncionarioDTORequest(
        String nome,

        LocalDate dataNascimento,
        Long departamentoId
) {
}
