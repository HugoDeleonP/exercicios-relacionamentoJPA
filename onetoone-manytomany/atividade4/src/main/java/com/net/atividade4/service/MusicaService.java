package com.net.atividade4.service;
import com.net.atividade4.dto.musica.MusicaDTORequest;
import com.net.atividade4.dto.musica.MusicaDTOResponse;
import com.net.atividade4.mapper.MusicaMapper;
import com.net.atividade4.model.Musica;
import com.net.atividade4.repository.MusicaRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MusicaService {

    private final MusicaRepository musicaRepository;
    private final MusicaMapper musicaMapper;

    public MusicaDTOResponse save(MusicaDTORequest musicaDto){

        Musica musica = musicaMapper.toEntity(musicaDto);

        return musicaMapper.toResponse(musicaRepository.save(musica));
    }


}
