package com.net.atividade3.controller;

import com.net.atividade3.dto.aluno.AlunoAndCursoDTORequest;
import com.net.atividade3.dto.aluno.AlunoAndCursoDTOResponse;
import com.net.atividade3.dto.aluno.AlunoDTORequest;
import com.net.atividade3.dto.aluno.AlunoDTOResponse;
import com.net.atividade3.service.AlunoService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    @PostMapping
    public ResponseEntity<AlunoDTOResponse> saveSimple(@RequestBody AlunoDTORequest alunoDTORequest){
        return ResponseEntity.status(200).body(alunoService.saveSimple(alunoDTORequest));
    }

    @PutMapping()
    public ResponseEntity<AlunoAndCursoDTOResponse> saveCompound(@RequestBody AlunoAndCursoDTORequest alunoAndCursoDTORequest){
        return ResponseEntity.status(200).body(alunoService.saveCompound(alunoAndCursoDTORequest));
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoAndCursoDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(200).body(alunoService.findById(id));
    }
}
