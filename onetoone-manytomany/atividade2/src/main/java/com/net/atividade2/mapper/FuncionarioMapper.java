package com.net.atividade2.mapper;

import com.net.atividade2.dto.funcionario.FuncionarioDTORequest;
import com.net.atividade2.dto.funcionario.FuncionarioDTOResponse;
import com.net.atividade2.model.Funcionario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FuncionarioMapper {

    private final EnderecoMapper enderecoMapper;
    public Funcionario toEntity(FuncionarioDTORequest funcionarioDTORequest){
        return new Funcionario(
                funcionarioDTORequest.nome()
        );
    }

    public FuncionarioDTOResponse toResponse(Funcionario funcionario){
        return new FuncionarioDTOResponse(
                funcionario.getId(),
                funcionario.getNome(),
                enderecoMapper.toResponse(funcionario.getEndereco())
        );
    }
}
