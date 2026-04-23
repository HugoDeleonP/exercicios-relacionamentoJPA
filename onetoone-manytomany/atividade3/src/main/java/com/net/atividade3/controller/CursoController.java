package com.net.atividade3.controller;

import com.net.atividade3.dto.aluno.AlunoAndCursoDTORequest;
import com.net.atividade3.dto.aluno.AlunoAndCursoDTOResponse;
import com.net.atividade3.dto.aluno.AlunoDTORequest;
import com.net.atividade3.dto.aluno.AlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoAndAlunoDTORequest;
import com.net.atividade3.dto.curso.CursoAndAlunoDTOResponse;
import com.net.atividade3.dto.curso.CursoDTORequest;
import com.net.atividade3.dto.curso.CursoDTOResponse;
import com.net.atividade3.service.CursoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cursos")
@RequiredArgsConstructor
public class CursoController {

    private final CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDTOResponse> saveSimple(@RequestBody CursoDTORequest cursoDTORequest){
        return ResponseEntity.status(200).body(cursoService.saveSimple(cursoDTORequest));

    }
    @GetMapping("/{id}")
    public ResponseEntity<CursoAndAlunoDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(200).body(cursoService.findById(id));
    }
}
