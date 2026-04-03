package com.net.atividade3.dto.categoria;

import java.util.List;

public record CategoriaDTOResponse(
        Long id,
        String nome,
        List<String> nomeProdutos
) {
}
