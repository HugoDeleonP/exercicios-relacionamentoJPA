package com.net.atividade2.mapper;

import com.net.atividade2.dto.pedido.PedidoDTORequest;
import com.net.atividade2.dto.pedido.PedidoDTOResponse;
import com.net.atividade2.model.Pedido;
import org.springframework.stereotype.Component;

@Component
public class PedidoMapper {

    public PedidoDTOResponse paraResposta(Pedido pedido){
        return new PedidoDTOResponse(
                pedido.getDescricao(),
                pedido.getCliente().getNome()
        );
    }

    public Pedido paraEntidade(PedidoDTORequest pedidoDTORequest){
        return new Pedido(
                pedidoDTORequest.descricao()
        );
    }
}
