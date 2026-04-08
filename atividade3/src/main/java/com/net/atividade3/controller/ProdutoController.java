package com.net.atividade3.controller;

import com.net.atividade3.dto.produto.ProdutoDTORequest;
import com.net.atividade3.dto.produto.ProdutoDTOResponse;
import com.net.atividade3.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    public ResponseEntity<ProdutoDTOResponse> save(ProdutoDTORequest produtoDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(produtoService.save(produtoDTORequest));
    }

    public ResponseEntity<List<ProdutoDTOResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findAll());
    }

    public ResponseEntity<List<ProdutoDTOResponse>> findByCategoria(Long categoriaId){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findByCategoria(categoriaId));
    }

    public ResponseEntity<ProdutoDTOResponse> findByNome(String nome){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findByNome(nome));

    }

    public ResponseEntity<ProdutoDTOResponse> findByIdAndNome(Long id, String nome){
        return ResponseEntity.status(HttpStatus.OK)
                .body(produtoService.findByIdAndNome(id, nome));
    }
}
