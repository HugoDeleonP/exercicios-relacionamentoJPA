package com.net.atividade2.repository;

import com.net.atividade2.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    Optional<Pedido> findByIdAndDescricao(Long id, String descricao);
    List<Pedido> findByClienteId(Long clienteId);
    Optional<Pedido> findByClienteNome(String clienteNome);
}
