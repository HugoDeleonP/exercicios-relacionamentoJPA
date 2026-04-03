package com.net.atividade3.service;

import com.net.atividade3.dto.produto.ProdutoDTORequest;
import com.net.atividade3.dto.produto.ProdutoDTOResponse;
import com.net.atividade3.mapper.ProdutoMapper;
import com.net.atividade3.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoDTOResponse save(ProdutoDTORequest produtoDTORequest){
        return produtoMapper.paraResponse(produtoRepository.save(produtoMapper.paraEntidade(produtoDTORequest)));
    }

    public List<ProdutoDTOResponse> findAll(){
        return produtoRepository.findAll().stream()
                .map(produtoMapper::paraResponse)
                .toList();
    }

    public List<ProdutoDTOResponse> findByCategoria(Long categoriaId){
        return produtoRepository.findByCategoria(categoriaId);
    }

    public ProdutoDTOResponse findByNome(String nome){

        return produtoRepository.findByNome(nome)
                .orElseThrow( () -> new RuntimeException("Produto não encontrado"));

    }

    public ProdutoDTOResponse findByIdAndNome(Long id, String nome){
        return produtoRepository.findByIdAndNome(id, nome)
                .orElseThrow( () -> new RuntimeException("Produto não encontrado"));
    }
}
