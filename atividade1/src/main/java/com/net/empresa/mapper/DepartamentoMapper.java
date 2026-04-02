package com.net.empresa.mapper;

import com.net.empresa.dto.departamento.DepartamentoDTOListFuncionario;
import com.net.empresa.dto.departamento.DepartamentoDTORequest;
import com.net.empresa.dto.departamento.DepartamentoDTOResponse;
import com.net.empresa.model.Departamento;
import com.net.empresa.model.Funcionario;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartamentoMapper {

    public Departamento toEntity(DepartamentoDTORequest departamentoDTORequest){
        return new Departamento(
                departamentoDTORequest.nome(),
                departamentoDTORequest.piso()
        );
    }

    public DepartamentoDTOResponse toResponse(Departamento departamento){

        List<DepartamentoDTOListFuncionario> funcionarios = new ArrayList<>();

        if(departamento.getFuncionarios() != null){
            funcionarios = departamento.getFuncionarios().stream()
                    .map(funcionario -> new DepartamentoDTOListFuncionario(funcionario.getNome(), funcionario.getDataNascimento()))
                    .toList();
        }

        return new DepartamentoDTOResponse(
                departamento.getId(),
                departamento.getNome(),
                departamento.getPiso(),
                funcionarios
        );
    }
}
