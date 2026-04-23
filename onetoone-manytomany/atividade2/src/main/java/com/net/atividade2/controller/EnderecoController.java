package com.net.atividade2.controller;

import com.net.atividade2.dto.endereco.EnderecoDTORequest;
import com.net.atividade2.dto.endereco.EnderecoDTOResponse;
import com.net.atividade2.dto.funcionario.FuncionarioDTORequest;
import com.net.atividade2.dto.funcionario.FuncionarioDTOResponse;
import com.net.atividade2.service.EnderecoService;
import com.net.atividade2.service.FuncionarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/enderecos")
@RequiredArgsConstructor
public class EnderecoController {

    private final EnderecoService enderecoService;

    @PostMapping
    public ResponseEntity<EnderecoDTOResponse> save(@Valid @RequestBody EnderecoDTORequest enderecoDTORequest){

        return ResponseEntity.status(200).body(enderecoService.save(enderecoDTORequest));
    }
}
