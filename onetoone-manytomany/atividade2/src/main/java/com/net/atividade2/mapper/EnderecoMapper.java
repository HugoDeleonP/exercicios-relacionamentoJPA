package com.net.atividade2.mapper;

import com.net.atividade2.dto.endereco.EnderecoDTORequest;
import com.net.atividade2.dto.endereco.EnderecoDTOResponse;
import com.net.atividade2.model.Endereco;
import org.springframework.stereotype.Component;

@Component

public class EnderecoMapper {

    public Endereco toEntity(EnderecoDTORequest enderecoDTORequest){
        return new Endereco(
                enderecoDTORequest.rua(),
                enderecoDTORequest.numero()
        );
    }

    public EnderecoDTOResponse toResponse(Endereco endereco){
        return new EnderecoDTOResponse(
                endereco.getId(),
                endereco.getRua(),
                endereco.getNumero()
        );


    }
}
