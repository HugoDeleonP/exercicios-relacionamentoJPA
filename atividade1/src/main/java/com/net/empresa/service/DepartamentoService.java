package com.net.empresa.service;

import com.net.empresa.dto.departamento.DepartamentoDTORequest;
import com.net.empresa.dto.departamento.DepartamentoDTOResponse;
import com.net.empresa.mapper.DepartamentoMapper;
import com.net.empresa.model.Departamento;
import com.net.empresa.repository.DepartamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartamentoService {

    private final DepartamentoRepository departamentoRepository;
    private final DepartamentoMapper departamentoMapper;

    public DepartamentoDTOResponse save(DepartamentoDTORequest dtoRequest){

        Departamento departamentoDatabase = departamentoMapper.toEntity(dtoRequest);

        return departamentoMapper.toResponse(departamentoRepository.save(departamentoDatabase));

    }

    public List<DepartamentoDTOResponse> findAll(){

        return departamentoRepository.findAll().stream()
                .map(departamentoMapper::toResponse)
                .toList();
    }

    public DepartamentoDTOResponse findById(Long id){

        Departamento departamentoBuscado = departamentoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado!"));

        return departamentoMapper.toResponse(departamentoBuscado);

    }

}
