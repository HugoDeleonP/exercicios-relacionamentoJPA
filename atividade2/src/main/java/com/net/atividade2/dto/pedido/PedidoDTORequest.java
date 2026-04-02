package com.net.atividade2.dto.pedido;

public record PedidoDTORequest(
        String descricao,
        Long clienteId
) {
}
