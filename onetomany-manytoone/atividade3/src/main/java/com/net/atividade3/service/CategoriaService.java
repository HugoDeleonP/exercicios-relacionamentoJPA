package com.net.atividade3.service;

import com.net.atividade3.dto.categoria.CategoriaDTORequest;
import com.net.atividade3.dto.categoria.CategoriaDTOResponse;
import com.net.atividade3.mapper.CategoriaMapper;
import com.net.atividade3.model.Categoria;
import com.net.atividade3.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaDTOResponse save(CategoriaDTORequest categoriaDTORequest){

        Categoria categoria = categoriaMapper.paraEntidade(categoriaDTORequest);

        return categoriaMapper.paraResponse(categoriaRepository.save(categoria));
    }
    public CategoriaDTOResponse findById(Long id){
        Categoria categoriaBuscada = categoriaRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("Categoria não encontrada!"));

        return categoriaMapper.paraResponse(categoriaBuscada);
    }
}
