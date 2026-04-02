package com.net.atividade2.mapper;

import com.net.atividade2.dto.cliente.ClienteDTOPedidos;
import com.net.atividade2.dto.cliente.ClienteDTORequest;
import com.net.atividade2.dto.cliente.ClienteDTOResponse;
import com.net.atividade2.model.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteMapper {

    public ClienteDTOResponse paraResposta(Cliente cliente){

        List<ClienteDTOPedidos> pedidosList = new ArrayList<>();

        if(cliente.getPedidos() != null){
            pedidosList = cliente.getPedidos().stream()
                    .map(pedido -> new ClienteDTOPedidos(pedido.getId(), pedido.getDescricao()))
                    .toList();
        }

        return new ClienteDTOResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getDataNascimento(),
                pedidosList
        );
    }

    public Cliente paraEntidade(ClienteDTORequest clienteDTORequest){
        return new Cliente(
                clienteDTORequest.nome(),
                clienteDTORequest.dataNascimento()
        );
    }
}
