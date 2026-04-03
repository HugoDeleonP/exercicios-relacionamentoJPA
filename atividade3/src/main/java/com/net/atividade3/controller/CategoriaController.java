package com.net.atividade3.controller;


import com.net.atividade3.dto.categoria.CategoriaDTORequest;
import com.net.atividade3.dto.categoria.CategoriaDTOResponse;
import com.net.atividade3.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<CategoriaDTOResponse> save(@RequestBody CategoriaDTORequest categoriaDTORequest){
        return ResponseEntity.ok(categoriaService.save(categoriaDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(categoriaService.findById(id));
    }

}
