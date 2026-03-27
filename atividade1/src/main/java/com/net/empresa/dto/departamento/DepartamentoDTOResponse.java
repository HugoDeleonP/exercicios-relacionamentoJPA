package com.net.empresa.dto.departamento;

import java.util.List;

public record DepartamentoDTOResponse(
        Long id,
        String nome,
        Integer piso,
        List<DepartamentoDTOListFuncionario> funcionarios
) {
}
