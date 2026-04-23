package com.net.atividade3.service;

import com.net.atividade3.dto.aluno.AlunoAndCursoDTORequest;
import com.net.atividade3.dto.aluno.AlunoAndCursoDTOResponse;
import com.net.atividade3.dto.aluno.AlunoDTORequest;
import com.net.atividade3.dto.aluno.AlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoAndAlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoDTORequest;
import com.net.atividade3.dto.curso.CursoDTOResponse;
import com.net.atividade3.mapper.AlunoMapper;
import com.net.atividade3.mapper.CursoMapper;
import com.net.atividade3.model.Aluno;
import com.net.atividade3.model.Curso;
import com.net.atividade3.repository.AlunoRepository;
import com.net.atividade3.repository.CursoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CursoService {

    private final CursoMapper cursoMapper;
    private final CursoRepository cursoRepository;

    private final AlunoMapper alunoMapper;
    private final AlunoRepository alunoRepository;

    public CursoDTOResponse saveSimple(CursoDTORequest cursoDTORequest){
        Curso curso = cursoMapper.toEntity(cursoDTORequest);

        return cursoMapper.toResponseSimple(cursoRepository.save(curso));
    }
    public CursoAndAlunoDTOResponse findById(Long id){
        Curso cursoBuscado = cursoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Curso não encontrado"));

        return cursoMapper.toResponseCompound(cursoBuscado);
    }

}
