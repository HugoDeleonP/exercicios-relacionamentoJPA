package com.net.atividade2.dto.cliente;

import java.time.LocalDate;
import java.util.List;

public record ClienteDTOResponse(
        Long id,
        String nome,
        LocalDate dataNascimento,
        List<ClienteDTOPedidos> pedidos
) {
}
