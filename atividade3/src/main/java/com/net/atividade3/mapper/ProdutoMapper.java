package com.net.atividade3.mapper;

import com.net.atividade3.dto.categoria.CategoriaDTORequest;
import com.net.atividade3.dto.categoria.CategoriaDTOResponse;
import com.net.atividade3.dto.produto.ProdutoDTORequest;
import com.net.atividade3.dto.produto.ProdutoDTOResponse;
import com.net.atividade3.model.Categoria;
import com.net.atividade3.model.Produto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProdutoMapper {

    public Produto paraEntidade(ProdutoDTORequest produtoDTORequest){
        return new Produto(
                produtoDTORequest.nome(),
                produtoDTORequest.preco()
        );
    }

    public ProdutoDTOResponse paraResponse(Produto produto){
        return new ProdutoDTOResponse(
                produto.getId(),
                produto.getNome(),
                produto.getPreco(),
                produto.getCategoria().getNome()
        );
    }
}
