package com.net.empresa.controller;

import com.net.empresa.dto.departamento.DepartamentoDTORequest;
import com.net.empresa.dto.departamento.DepartamentoDTOResponse;
import com.net.empresa.dto.funcionario.FuncionarioDTOResponse;
import com.net.empresa.service.DepartamentoService;
import com.net.empresa.service.FuncionarioService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/departamentos")
public class DepartamentoController {

    private final DepartamentoService departamentoService;
    private final FuncionarioService funcionarioService;

    @PostMapping
    public ResponseEntity<DepartamentoDTOResponse> save( @RequestBody DepartamentoDTORequest departamentoDTORequest){
        return ResponseEntity.ok(departamentoService.save(departamentoDTORequest));
    }

    @GetMapping
    public ResponseEntity<List<DepartamentoDTOResponse>> findAll(){
        return ResponseEntity.ok(departamentoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(departamentoService.findById(id));
    }

    @GetMapping("{departamentoId}/funcionarios")
    public ResponseEntity<List<FuncionarioDTOResponse>> findByDepartamento(@PathVariable Long departamentoId){
        return ResponseEntity.ok(funcionarioService.findByDepartamento(departamentoId));
    }

}
