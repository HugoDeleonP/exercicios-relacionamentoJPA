package com.net.atividade1.controller;

import com.net.atividade1.dto.documento.DocumentoDTORequest;
import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import com.net.atividade1.service.DocumentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api/documentos")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;
    @PostMapping
    public ResponseEntity<DocumentoDTOResponse> save(@RequestBody DocumentoDTORequest documentoDTORequest){
        return ResponseEntity.status(200).body(documentoService.save(documentoDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentoDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(200).body(documentoService.findById(id));
    }
}
