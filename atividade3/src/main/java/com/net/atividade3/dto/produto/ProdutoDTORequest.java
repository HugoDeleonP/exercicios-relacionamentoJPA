package com.net.atividade3.dto.produto;

public record ProdutoDTORequest(
        String nome,
        Double preco,
        Long categoriaId
) {
}
