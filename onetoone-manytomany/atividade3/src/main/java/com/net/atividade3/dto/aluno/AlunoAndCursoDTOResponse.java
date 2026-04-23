package com.net.atividade3.dto.aluno;

import com.net.atividade3.dto.curso.CursoDTOResponse;

import java.util.List;

public record AlunoAndCursoDTOResponse(
        Long id,
        String nomeAluno,
        List<CursoDTOResponse> cursos

) {
}
