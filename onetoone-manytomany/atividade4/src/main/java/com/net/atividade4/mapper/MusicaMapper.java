package com.net.atividade4.mapper;

import com.net.atividade4.dto.musica.MusicaDTORequest;
import com.net.atividade4.dto.musica.MusicaDTOResponse;
import com.net.atividade4.model.Musica;
import org.springframework.stereotype.Component;

@Component
public class MusicaMapper {

    public Musica toEntity(MusicaDTORequest request){
        return new Musica(
                request.nome(),
                request.artista()
        );
    }

    public MusicaDTOResponse toResponse(Musica musica){
        return new MusicaDTOResponse(
                musica.getId(),
                musica.getNome(),
                musica.getArtista()
        );
    }
}
