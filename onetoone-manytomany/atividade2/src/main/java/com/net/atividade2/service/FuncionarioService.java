package com.net.atividade2.service;

import com.net.atividade2.dto.endereco.EnderecoDTORequest;
import com.net.atividade2.dto.endereco.EnderecoDTOResponse;
import com.net.atividade2.dto.funcionario.FuncionarioDTORequest;
import com.net.atividade2.dto.funcionario.FuncionarioDTOResponse;
import com.net.atividade2.mapper.EnderecoMapper;
import com.net.atividade2.mapper.FuncionarioMapper;
import com.net.atividade2.model.Endereco;
import com.net.atividade2.model.Funcionario;
import com.net.atividade2.repository.EnderecoRepository;
import com.net.atividade2.repository.FuncionarioRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioMapper funcionarioMapper;
    private final FuncionarioRepository funcionarioRepository;

    private final EnderecoMapper enderecoMapper;
    private final EnderecoRepository enderecoRepository;

    @Transactional
    public FuncionarioDTOResponse save(FuncionarioDTORequest funcionarioDTORequest){

        Funcionario funcionario = funcionarioMapper.toEntity(funcionarioDTORequest);

        Endereco enderecoBuscado = enderecoRepository.findByRuaAndNumero(funcionarioDTORequest.endereco().rua(), funcionarioDTORequest.endereco().numero())
                .orElseThrow(() -> new RuntimeException("Endereço não encontrado"));

        Funcionario funcionarioDatabase = funcionarioRepository.save(funcionario);

        if(enderecoBuscado.getFuncionario() != null){
            throw new RuntimeException("O endereço já tem o funcionário atribuido");
        }

        enderecoBuscado.setFuncionario(funcionarioDatabase);

        Endereco enderecoDatabase = enderecoRepository.save(enderecoBuscado);
        funcionarioDatabase.setEndereco(enderecoDatabase);

        return funcionarioMapper.toResponse(funcionarioDatabase);

    }

    public FuncionarioDTOResponse findById(Long id){

        Funcionario funcionarioBuscado = funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

        if(funcionarioBuscado.getEndereco() == null){
            throw new RuntimeException("Funcionário sem endereço");
        }

        return funcionarioMapper.toResponse(funcionarioBuscado);
    }



}
