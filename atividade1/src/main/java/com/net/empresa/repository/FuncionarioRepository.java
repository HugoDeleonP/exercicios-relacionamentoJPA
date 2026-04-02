package com.net.empresa.repository;

import com.net.empresa.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
    List<Funcionario> findByDepartamento(Long departamentoId);

    Optional<Funcionario> findByNome(String nomeFuncionario);
}
