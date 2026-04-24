package com.net.atividade4.dto.playlist;

import com.net.atividade4.dto.musica.MusicaDTOResponse;

import java.util.List;

public record PlaylistAndMusicaDTOResponse(
        Long id,
        String nome,
        List<MusicaDTOResponse> musicas
) {
}
