package com.net.atividade4.controller;

import com.net.atividade4.dto.musica.MusicaDTORequest;
import com.net.atividade4.dto.musica.MusicaDTOResponse;
import com.net.atividade4.service.MusicaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
@RequiredArgsConstructor
public class MusicaController {

    private final MusicaService musicaService;

    @PostMapping
    public ResponseEntity<MusicaDTOResponse> save(@RequestBody MusicaDTORequest musicaDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(musicaService.save(musicaDTORequest));
    }
}
