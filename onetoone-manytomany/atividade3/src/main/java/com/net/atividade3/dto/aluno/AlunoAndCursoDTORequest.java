package com.net.atividade3.dto.aluno;

import com.net.atividade3.dto.curso.CursoDTORequest;

public record AlunoAndCursoDTORequest(
        String nome,
        CursoDTORequest curso
) {
}
