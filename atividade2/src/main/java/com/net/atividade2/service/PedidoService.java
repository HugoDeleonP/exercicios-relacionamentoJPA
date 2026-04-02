package com.net.atividade2.service;

import com.net.atividade2.dto.cliente.ClienteDTORequest;
import com.net.atividade2.dto.cliente.ClienteDTOResponse;
import com.net.atividade2.dto.pedido.PedidoDTORequest;
import com.net.atividade2.dto.pedido.PedidoDTOResponse;
import com.net.atividade2.mapper.ClienteMapper;
import com.net.atividade2.mapper.PedidoMapper;
import com.net.atividade2.model.Cliente;
import com.net.atividade2.model.Pedido;
import com.net.atividade2.repository.ClienteRepository;
import com.net.atividade2.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final PedidoMapper pedidoMapper;

    public PedidoDTOResponse save(PedidoDTORequest pedidoDTORequest){

        Cliente clienteBuscado = clienteRepository.findById(pedidoDTORequest.clienteId())
                .orElseThrow( () -> new RuntimeException("Cliente não encontrado!"));

        Pedido pedido = pedidoMapper.paraEntidade(pedidoDTORequest);
        pedido.setCliente(clienteBuscado);

        return pedidoMapper.paraResposta(
                pedidoRepository.save(pedido));
    }

    public List<PedidoDTOResponse> findAll(){
        return pedidoRepository.findAll().stream()
                .map(pedidoMapper::paraResposta)
                .toList();
    }

    public PedidoDTOResponse findById(Long id){

        Pedido pedidoBuscado = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.paraResposta(pedidoBuscado);
    }

    public List<PedidoDTOResponse> findByClienteId(Long clienteId){
        List<Pedido> pedidoBuscado = pedidoRepository.findByClienteId(clienteId);

        return pedidoBuscado.stream()
                .map(pedidoMapper::paraResposta)
                .collect(Collectors.toList());
    }

    public PedidoDTOResponse findByIdAndDescricao(Long id, String descricao){
        Pedido pedidoBuscado = pedidoRepository.findByIdAndDescricao(id, descricao)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.paraResposta(pedidoBuscado);
    }

    public PedidoDTOResponse findByClienteNome(String clienteNome){
        Pedido pedidoBuscado = pedidoRepository.findByClienteNome(clienteNome)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));

        return pedidoMapper.paraResposta(pedidoBuscado);
    }


}
