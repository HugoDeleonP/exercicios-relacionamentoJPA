package com.net.atividade2.service;

import com.net.atividade2.dto.cliente.ClienteDTORequest;
import com.net.atividade2.dto.cliente.ClienteDTOResponse;
import com.net.atividade2.mapper.ClienteMapper;
import com.net.atividade2.model.Cliente;
import com.net.atividade2.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteDTOResponse save(ClienteDTORequest clienteDTORequest){
        return clienteMapper.paraResposta(
                clienteRepository.save(clienteMapper.paraEntidade(clienteDTORequest)));
    }

    public List<ClienteDTOResponse> findAll(){
        return clienteRepository.findAll().stream()
                .map(clienteMapper::paraResposta)
                .toList();
    }

    public void deleteById(Long id){

        Cliente clienteBuscado = clienteRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Cliente não encontrado"));

        clienteRepository.deleteById(clienteBuscado.getId());
    }
}
