package com.net.atividade2.controller;

import com.net.atividade2.dto.pedido.PedidoDTORequest;
import com.net.atividade2.dto.pedido.PedidoDTOResponse;
import com.net.atividade2.model.Cliente;
import com.net.atividade2.model.Pedido;
import com.net.atividade2.service.ClienteService;
import com.net.atividade2.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<PedidoDTOResponse> save(@RequestBody PedidoDTORequest pedidoDTORequest){
        return ResponseEntity.ok(pedidoService.save(pedidoDTORequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<PedidoDTOResponse>> findAll(){
        return ResponseEntity.ok(pedidoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDTOResponse> findById(@PathVariable Long id){
        return ResponseEntity.ok(pedidoService.findById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<PedidoDTOResponse> findByIdAndDescricao(@RequestParam Long id, @RequestParam String descricao){
        return ResponseEntity.ok(pedidoService.findByIdAndDescricao(id, descricao));
    }

    @GetMapping
    public ResponseEntity<PedidoDTOResponse> findByClienteNome(@RequestParam String clienteNome){
        return ResponseEntity.ok(pedidoService.findByClienteNome(clienteNome));
    }
}
