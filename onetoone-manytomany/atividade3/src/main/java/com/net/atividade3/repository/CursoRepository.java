package com.net.atividade3.repository;

import com.net.atividade3.model.Aluno;
import com.net.atividade3.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Long> {

    Optional<Curso> findByNome(String nome);

}
