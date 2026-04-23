package com.net.atividade3.mapper;

import com.net.atividade3.dto.aluno.AlunoAndCursoDTOResponse;
import com.net.atividade3.dto.aluno.AlunoDTORequest;
import com.net.atividade3.dto.aluno.AlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoAndAlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoDTORequest;
import com.net.atividade3.dto.curso.CursoDTOResponse;
import com.net.atividade3.model.Aluno;
import com.net.atividade3.model.Curso;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class CursoMapper {

    private final AlunoMapper alunoMapper;

    public CursoDTOResponse toResponseSimple(Curso curso){
        return new CursoDTOResponse(
                curso.getId(),
                curso.getNome()
        );
    }
    public CursoAndAlunoDTOResponse toResponseCompound(Curso curso){

        List<AlunoDTOResponse> alunos = new ArrayList<>();

        if(curso.getAlunos() != null){
            alunos = curso.getAlunos().stream()
                    .map(alunoMapper::toResponseSimple)
                    .toList();
        }

        return new CursoAndAlunoDTOResponse(
                curso.getId(),
                curso.getNome(),
                alunos
        );
    }
    public Curso toEntity(CursoDTORequest curso){
        return new Curso(
                curso.nome()
        );
    }
}
