package com.net.atividade3.service;

import com.net.atividade3.dto.aluno.AlunoAndCursoDTORequest;
import com.net.atividade3.dto.aluno.AlunoAndCursoDTOResponse;
import com.net.atividade3.dto.aluno.AlunoDTORequest;
import com.net.atividade3.dto.aluno.AlunoDTOResponse;
import com.net.atividade3.mapper.AlunoMapper;
import com.net.atividade3.mapper.CursoMapper;
import com.net.atividade3.model.Aluno;
import com.net.atividade3.model.Curso;
import com.net.atividade3.repository.AlunoRepository;
import com.net.atividade3.repository.CursoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoMapper alunoMapper;
    private final AlunoRepository alunoRepository;

    private final CursoMapper cursoMapper;
    private final CursoRepository cursoRepository;

    public AlunoDTOResponse saveSimple(AlunoDTORequest alunoDTORequest){

        Aluno aluno = alunoMapper.toEntity(alunoDTORequest);

        return alunoMapper.toResponseSimple(alunoRepository.save(aluno));
    }

    @Transactional
    public AlunoAndCursoDTOResponse saveCompound(AlunoAndCursoDTORequest alunoAndCursoDTORequest){

        Aluno aluno = alunoRepository.findByNome(alunoAndCursoDTORequest.nome())
                .orElseThrow( () -> new RuntimeException("Aluno não encontrado"));

        List<Curso> cursosAgregados = aluno.getCursos();

        Curso curso = cursoRepository.findByNome(alunoAndCursoDTORequest.curso().nome())
                .orElseThrow( () -> new RuntimeException("Curso não encontrado"));

        List<Aluno> alunosAgregados = curso.getAlunos();

        if(!cursosAgregados.contains(curso) ){
            cursosAgregados.add(curso);
            aluno.setCursos(cursosAgregados);
        }

        if(!alunosAgregados.contains(aluno)){
            alunosAgregados.add(aluno);
            curso.setAlunos(alunosAgregados);
        }

        Aluno alunoDatabase = alunoRepository.save(aluno);
        cursoRepository.save(curso);

        return alunoMapper.toResponseCompound(alunoDatabase);
    }

    public AlunoAndCursoDTOResponse findById(Long id){
        Aluno alunoBuscado = alunoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Aluno não encontrado"));

        return alunoMapper.toResponseCompound(alunoBuscado);
    }
}
