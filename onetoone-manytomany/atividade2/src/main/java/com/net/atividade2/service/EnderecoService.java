package com.net.atividade2.service;

import com.net.atividade2.dto.endereco.EnderecoDTORequest;
import com.net.atividade2.dto.endereco.EnderecoDTOResponse;
import com.net.atividade2.dto.funcionario.FuncionarioDTORequest;
import com.net.atividade2.dto.funcionario.FuncionarioDTOResponse;
import com.net.atividade2.mapper.EnderecoMapper;
import com.net.atividade2.model.Endereco;
import com.net.atividade2.model.Funcionario;
import com.net.atividade2.repository.EnderecoRepository;
import com.net.atividade2.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnderecoService {

    private final EnderecoMapper enderecoMapper;
    private final EnderecoRepository enderecoRepository;

    public EnderecoDTOResponse save(EnderecoDTORequest enderecoDTORequest){

        Endereco endereco = enderecoMapper.toEntity(enderecoDTORequest);

        if(enderecoRepository.existsByRuaAndNumero(enderecoDTORequest.rua(), enderecoDTORequest.numero())){
            throw new RuntimeException("O endereço já existe");
        }

        return enderecoMapper.toResponse(enderecoRepository.save(endereco));
    }

    public EnderecoDTOResponse findById(Long id){

        Endereco enderecoBuscado = enderecoRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Endereço não encontrado"));

        return enderecoMapper.toResponse(enderecoBuscado);
    }

    public List<EnderecoDTOResponse> index(){

        List<Endereco> enderecos = enderecoRepository.findAll();

        return enderecos.stream()
                .map(enderecoMapper::toResponse)
                .toList();
    }

}
