package com.net.atividade3.dto.curso;

import com.net.atividade3.dto.aluno.AlunoDTOResponse;

import java.util.List;

public record CursoAndAlunoDTOResponse(
        Long id,
        String nomeCurso,
        List<AlunoDTOResponse> alunos
) {
}
