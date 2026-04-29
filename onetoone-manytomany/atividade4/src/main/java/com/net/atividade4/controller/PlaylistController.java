package com.net.atividade4.controller;

import com.net.atividade4.dto.playlist.PlaylistAndMusicaDTORequest;
import com.net.atividade4.dto.playlist.PlaylistAndMusicaDTOResponse;
import com.net.atividade4.dto.playlist.PlaylistDTORequest;
import com.net.atividade4.dto.playlist.PlaylistDTOResponse;
import com.net.atividade4.service.PlaylistService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlists")
@RequiredArgsConstructor
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    public ResponseEntity<PlaylistDTOResponse> save(@RequestBody PlaylistDTORequest playlistDTORequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(playlistService.save(playlistDTORequest));
    }

    @PutMapping
    public ResponseEntity<PlaylistAndMusicaDTOResponse> addMusicsInPlaylist(@RequestBody PlaylistAndMusicaDTORequest playlistAndMusica){
        return ResponseEntity.status(HttpStatus.OK)
                .body(playlistService.saveCompound(playlistAndMusica));

    }

    @GetMapping("/{id}")
    public ResponseEntity<PlaylistAndMusicaDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK)
                .body(playlistService.findById(id));
    }
}
