package com.net.atividade2.repository;

import com.net.atividade2.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    Optional<Endereco> findByRuaAndNumero(String rua, String numero);
    Boolean existsByRuaAndNumero(String rua, String numero);
    Boolean existsByFuncionarioId(Long funcionarioId);

}
