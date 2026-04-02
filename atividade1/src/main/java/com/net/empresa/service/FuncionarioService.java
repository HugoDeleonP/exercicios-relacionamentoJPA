package com.net.empresa.service;

import com.net.empresa.dto.departamento.DepartamentoDTOListFuncionario;
import com.net.empresa.dto.departamento.DepartamentoDTORequest;
import com.net.empresa.dto.departamento.DepartamentoDTOResponse;
import com.net.empresa.dto.funcionario.FuncionarioDTORequest;
import com.net.empresa.dto.funcionario.FuncionarioDTOResponse;
import com.net.empresa.mapper.DepartamentoMapper;
import com.net.empresa.mapper.FuncionarioMapper;
import com.net.empresa.model.Departamento;
import com.net.empresa.model.Funcionario;
import com.net.empresa.repository.DepartamentoRepository;
import com.net.empresa.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;
    private final DepartamentoRepository departamentoRepository;
    private final FuncionarioMapper funcionarioMapper;
    private final DepartamentoMapper departamentoMapper;

    public FuncionarioDTOResponse save(FuncionarioDTORequest funcionarioDTORequest){

        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioDTORequest);

        Departamento departamentoBuscado = departamentoRepository.findById(funcionarioDTORequest.departamentoId())
                        .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        funcionario.setDepartamento(departamentoBuscado);

        return funcionarioMapper.toResponse(
                funcionarioRepository.save(funcionario));
    }

    public List<FuncionarioDTOResponse> listAll(){
        return funcionarioRepository.findAll().stream()
                .map(funcionarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    public FuncionarioDTOResponse findById(Long id){
        Funcionario funcionarioBuscado = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return funcionarioMapper.toResponse(funcionarioBuscado);
    }

    public List<FuncionarioDTOResponse> findByDepartamento(Long departamentoId){
        List<Funcionario> funcionariosBuscados = funcionarioRepository.findByDepartamento(departamentoId);

        return funcionariosBuscados.stream()
                .map( funcionarioMapper::toResponse)
                .collect(Collectors.toList());
    }

    public FuncionarioDTOResponse findByNome(String nomeFuncionario){
        Funcionario funcionarioBuscado = funcionarioRepository.findByNome(nomeFuncionario)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        return funcionarioMapper.toResponse(funcionarioBuscado);
    }


}
