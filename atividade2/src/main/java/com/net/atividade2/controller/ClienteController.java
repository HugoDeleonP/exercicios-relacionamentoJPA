package com.net.atividade2.controller;

import com.net.atividade2.dto.cliente.ClienteDTORequest;
import com.net.atividade2.dto.cliente.ClienteDTOResponse;
import com.net.atividade2.dto.pedido.PedidoDTOResponse;
import com.net.atividade2.service.ClienteService;
import com.net.atividade2.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<ClienteDTOResponse> save(@RequestBody ClienteDTORequest clienteDTORequest){
        return ResponseEntity.ok(clienteService.save(clienteDTORequest));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ClienteDTOResponse>> findAll(){
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{clienteId}/pedidos")
    public ResponseEntity<List<PedidoDTOResponse>> findByClienteId(@PathVariable Long clienteId){
        return ResponseEntity.ok(pedidoService.findByClienteId(clienteId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        clienteService.deleteById(id);
        return ResponseEntity.ok("Deletado com sucesso!");
    }
}
