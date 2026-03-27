package com.net.empresa.dto.departamento;

import jakarta.persistence.Column;

import java.time.LocalDate;

public record DepartamentoDTOListFuncionario(

         String nome,

         LocalDate dataNascimento
) {
}
