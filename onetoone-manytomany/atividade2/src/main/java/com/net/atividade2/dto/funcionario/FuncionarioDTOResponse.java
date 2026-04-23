package com.net.atividade2.dto.funcionario;

import com.net.atividade2.dto.endereco.EnderecoDTOResponse;

public record FuncionarioDTOResponse(
        Long id,
        String nome,
        EnderecoDTOResponse endereco
) {
}
