package com.net.atividade1.dto.pessoa;

import com.net.atividade1.dto.documento.DocumentoDTOResponse;

public record PessoaDTOResponse(
    Long id,
    String nome,
    DocumentoDTOResponse documento
) {
}
