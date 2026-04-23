package com.net.atividade1.controller;


import com.net.atividade1.dto.documento.DocumentoDTORequest;
import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import com.net.atividade1.dto.pessoa.PessoaDTORequest;
import com.net.atividade1.dto.pessoa.PessoaDTOResponse;
import com.net.atividade1.dto.pessoa.PessoaDocumentoDTORequest;
import com.net.atividade1.service.DocumentoService;
import com.net.atividade1.service.PessoaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/pessoas")
public class PessoaController {

    private final PessoaService pessoaService;

    @PostMapping
    public ResponseEntity<PessoaDTOResponse> save(@RequestBody PessoaDocumentoDTORequest pessoaDocumentoDTORequest){
        return ResponseEntity.status(200).body(pessoaService.save(pessoaDocumentoDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(200).body(pessoaService.findById(id));
    }
}
