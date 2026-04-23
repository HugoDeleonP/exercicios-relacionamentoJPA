package com.net.atividade1.repository;

import com.net.atividade1.model.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentoRepository extends JpaRepository<Documento, Long> {

    boolean existsByNumeroAndTipo(String numero, String tipo);
}
