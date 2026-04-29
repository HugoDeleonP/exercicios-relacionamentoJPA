package com.net.atividade4.mapper;

import com.net.atividade4.dto.musica.MusicaDTORequest;
import com.net.atividade4.dto.musica.MusicaDTOResponse;
import com.net.atividade4.dto.playlist.PlaylistAndMusicaDTORequest;
import com.net.atividade4.dto.playlist.PlaylistAndMusicaDTOResponse;
import com.net.atividade4.dto.playlist.PlaylistDTORequest;
import com.net.atividade4.dto.playlist.PlaylistDTOResponse;
import com.net.atividade4.model.Musica;
import com.net.atividade4.model.Playlist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class PlaylistMapper {

    private final MusicaMapper musicaMapper;

    public Playlist toEntity(PlaylistDTORequest request){
        return new Playlist(
                request.nome()
        );
    }

    public Playlist toEntity(PlaylistAndMusicaDTORequest playlistAndMusica){
        return new Playlist(
                playlistAndMusica.nome()
        );
    }
    public PlaylistDTOResponse toResponseSimple(Playlist playlist){
        return new PlaylistDTOResponse(
                playlist.getId(),
                playlist.getNome()
        );
    }

    public PlaylistAndMusicaDTOResponse toResponseCompound(Playlist playlist){

        List<Musica> musicas = playlist.getMusicas();
        List<MusicaDTOResponse> musicasDTO = new ArrayList<>();

        if(musicas != null){
            musicasDTO = musicas.stream()
                    .map( musicaMapper::toResponse)
                    .toList();
        }

        return new PlaylistAndMusicaDTOResponse(
                playlist.getId(),
                playlist.getNome(),
                (musicas != null)? musicasDTO : null
        );
    }
}
