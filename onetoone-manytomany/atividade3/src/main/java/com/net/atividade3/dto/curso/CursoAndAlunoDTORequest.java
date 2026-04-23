package com.net.atividade3.dto.curso;

import com.net.atividade3.dto.aluno.AlunoDTORequest;

public record CursoAndAlunoDTORequest(
        String nomeCurso,
        AlunoDTORequest alunoDTORequest

) {
}
