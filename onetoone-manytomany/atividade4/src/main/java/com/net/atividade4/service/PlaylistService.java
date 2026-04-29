package com.net.atividade4.service;

import com.net.atividade4.dto.playlist.PlaylistAndMusicaDTORequest;
import com.net.atividade4.dto.playlist.PlaylistAndMusicaDTOResponse;
import com.net.atividade4.dto.playlist.PlaylistDTORequest;
import com.net.atividade4.dto.playlist.PlaylistDTOResponse;
import com.net.atividade4.mapper.PlaylistMapper;
import com.net.atividade4.model.Musica;
import com.net.atividade4.model.Playlist;
import com.net.atividade4.repository.MusicaRepository;
import com.net.atividade4.repository.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final PlaylistMapper playlistMapper;
    private final MusicaRepository musicaRepository;

    public PlaylistDTOResponse save(PlaylistDTORequest playlistDto){

        Playlist playlist = playlistMapper.toEntity(playlistDto);

        return playlistMapper.toResponseSimple(playlistRepository.save(playlist));

    }

    public PlaylistAndMusicaDTOResponse saveCompound(PlaylistAndMusicaDTORequest playlistAndMusica){
        Musica musica = musicaRepository.findById( playlistAndMusica.musicaId())
                .orElseThrow( () -> new RuntimeException("Música não encontrada"));

        Playlist playlist = playlistRepository.findByNome(playlistAndMusica.nome())
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));

        List<Musica> musicas = playlist.getMusicas();
        musicas.add(musica);
        playlist.setMusicas(musicas);

        return playlistMapper.toResponseCompound(playlistRepository.save(playlist));
    }

    public PlaylistAndMusicaDTOResponse findById(Long id){
        Playlist playlist = playlistRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));

        return playlistMapper.toResponseCompound(playlist);
    }

}