package com.net.atividade1.mapper;

import com.net.atividade1.dto.documento.DocumentoDTORequest;
import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import com.net.atividade1.model.Documento;
import org.springframework.stereotype.Component;

@Component
public class DocumentoMapper{

    public Documento toEntity(DocumentoDTORequest dtoRequest) {
        return new Documento(
                dtoRequest.numero(),
                dtoRequest.tipo()
        );
    }

    public DocumentoDTOResponse toResponse(Documento entity) {
        return new DocumentoDTOResponse(
                entity.getId(),
                entity.getNumero(),
                entity.getTipo()
        );
    }
}
