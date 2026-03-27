package com.net.empresa.mapper;

import com.net.empresa.dto.funcionario.FuncionarioDTORequest;
import com.net.empresa.dto.funcionario.FuncionarioDTOResponse;
import com.net.empresa.model.Funcionario;

public class FuncionarioMapper {

    public Funcionario toEntity(FuncionarioDTORequest funcionarioDTORequest){
        return new Funcionario(funcionarioDTORequest.nome(), funcionarioDTORequest.dataNascimento());
    }

    public FuncionarioDTOResponse toResponse(Funcionario funcionario){
        return new FuncionarioDTOResponse(
                funcionario.getId(),
                funcionario.getNome(),
                funcionario.getDataNascimento(),
                funcionario.getDepartamento().getNome()
        );
    }
}
