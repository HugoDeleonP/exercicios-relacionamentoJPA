package com.net.atividade1.mapper;

import com.net.atividade1.dto.documento.DocumentoDTORequest;
import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import com.net.atividade1.dto.pessoa.PessoaDTORequest;
import com.net.atividade1.dto.pessoa.PessoaDTOResponse;
import com.net.atividade1.dto.pessoa.PessoaDocumentoDTORequest;
import com.net.atividade1.model.Pessoa;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PessoaMapper {

    private final DocumentoMapper documentoMapper;

    public Pessoa toEntity(PessoaDocumentoDTORequest dtoRequest) {
        return new Pessoa(
                dtoRequest.nome()
        );
    }

    public PessoaDTOResponse toResponse(Pessoa entity) {
        return new PessoaDTOResponse(
                entity.getId(),
                entity.getNome(),
                documentoMapper.toResponse(entity.getDocumento())
        );
    }

}
