package com.net.empresa.controller;

import com.net.empresa.dto.departamento.DepartamentoDTORequest;
import com.net.empresa.dto.departamento.DepartamentoDTOResponse;
import com.net.empresa.dto.funcionario.FuncionarioDTORequest;
import com.net.empresa.dto.funcionario.FuncionarioDTOResponse;
import com.net.empresa.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<FuncionarioDTOResponse> save(@RequestBody FuncionarioDTORequest funcionarioDTORequest){
        return ResponseEntity.ok(funcionarioService.save(funcionarioDTORequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<FuncionarioDTOResponse>> findAll(){
        return ResponseEntity.ok(funcionarioService.listAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<FuncionarioDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(funcionarioService.findById(id));
    }

    @GetMapping()
    public ResponseEntity<FuncionarioDTOResponse> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(funcionarioService.findByNome(nome));
    }


}
