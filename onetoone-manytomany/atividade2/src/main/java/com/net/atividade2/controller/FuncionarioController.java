package com.net.atividade2.controller;

import com.net.atividade2.dto.funcionario.FuncionarioDTORequest;
import com.net.atividade2.dto.funcionario.FuncionarioDTOResponse;
import com.net.atividade2.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/funcionarios")
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioDTOResponse> save(@Valid @RequestBody FuncionarioDTORequest funcionarioDTORequest){

        return ResponseEntity.status(200).body(funcionarioService.save(funcionarioDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTOResponse> findById(@PathVariable Long id){

        return ResponseEntity.status(200).body(funcionarioService.findById(id));
    }
}
