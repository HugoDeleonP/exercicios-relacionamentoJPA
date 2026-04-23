package com.net.atividade1.service;

import com.net.atividade1.dto.documento.DocumentoDTORequest;
import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import com.net.atividade1.mapper.DocumentoMapper;
import com.net.atividade1.model.Documento;
import com.net.atividade1.repository.DocumentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoRepository documentoRepository;
    private final DocumentoMapper documentoMapper;

    public List<DocumentoDTOResponse> index(){

        List<Documento> documentos = documentoRepository.findAll();

        return documentos.stream()
                .map(documentoMapper::toResponse)
                .toList();
    }

    public DocumentoDTOResponse save(DocumentoDTORequest request){

        Documento documentoDatabase = documentoRepository.save(documentoMapper.toEntity(request));

        return documentoMapper.toResponse(documentoDatabase);

    }

    public DocumentoDTOResponse findById(Long id){

        Documento documento = documentoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Documento não encontrado"));

        return documentoMapper.toResponse(documento);
    }

    public DocumentoDTOResponse update(Long id, DocumentoDTORequest request){

        Documento documento = documentoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Documento não encontrado"));

        documento.setNumero(request.numero());
        documento.setTipo(request.tipo());

        return documentoMapper.toResponse(documentoRepository.save(documento));
    }

    public void delete(Long id){

        documentoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Documento não encontrado"));

        documentoRepository.deleteById(id);
    }
}
