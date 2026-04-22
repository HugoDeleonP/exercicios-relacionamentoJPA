package com.net.atividade3.mapper;

import com.net.atividade3.dto.categoria.CategoriaDTORequest;
import com.net.atividade3.dto.categoria.CategoriaDTOResponse;
import com.net.atividade3.model.Categoria;
import com.net.atividade3.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CategoriaMapper {

    public Categoria paraEntidade(CategoriaDTORequest categoriaDTORequest){
        return new Categoria(
                categoriaDTORequest.nome()
        );
    }

    public CategoriaDTOResponse paraResponse(Categoria categoria){
        List<String> nomeProdutos = new ArrayList<>();

        if(categoria.getProdutos() != null){
            nomeProdutos = categoria.getProdutos().stream()
                    .map(Produto::getNome)
                    .toList();
        }

        return new CategoriaDTOResponse(
                categoria.getId(),
                categoria.getNome(),
                nomeProdutos
        );
    }
}
