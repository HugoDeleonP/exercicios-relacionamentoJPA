package com.net.atividade3.mapper;

import com.net.atividade3.dto.aluno.AlunoAndCursoDTOResponse;
import com.net.atividade3.dto.aluno.AlunoDTORequest;
import com.net.atividade3.dto.aluno.AlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoDTOResponse;
import com.net.atividade3.model.Aluno;
import com.net.atividade3.model.Curso;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class AlunoMapper {

    private CursoMapper cursoMapper;

    public AlunoDTOResponse toResponseSimple(Aluno aluno){
        return new AlunoDTOResponse(
                aluno.getId(),
                aluno.getNome()
        );
    }

    public AlunoAndCursoDTOResponse toResponseCompound(Aluno aluno){

        List<CursoDTOResponse> cursos = null;

        if(aluno.getCursos() != null){
            cursos = aluno.getCursos().stream()
                    .map( curso -> new CursoDTOResponse(curso.getId(), curso.getNome()))
                    .toList();
        }

        return new AlunoAndCursoDTOResponse(
                aluno.getId(),
                aluno.getNome(),
                cursos
        );
    }

    public Aluno toEntity(AlunoDTORequest aluno){
        return new Aluno(
                aluno.nome()
        );
    }
}
