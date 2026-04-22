package com.net.atividade2.dto.cliente;

import java.time.LocalDate;
import java.util.List;

public record ClienteDTORequest(
        String nome,
        LocalDate dataNascimento
) {}
