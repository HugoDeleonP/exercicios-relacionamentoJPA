package com.net.atividade3.repository;

import com.net.atividade3.dto.produto.ProdutoDTOResponse;
import com.net.atividade3.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    List<ProdutoDTOResponse> findByCategoria(Long categoriaId);

    Optional<ProdutoDTOResponse> findByNome(String nome);

    Optional<ProdutoDTOResponse> findByIdAndNome(Long id, String nome);
}
