package com.net.atividade3.dto.produto;

public record ProdutoDTOResponse(
        Long id,
        String nome,
        Double preco,
        String categoriaNome
) {
}
