package com.net.atividade1.service;

import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import com.net.atividade1.dto.pessoa.PessoaDTORequest;
import com.net.atividade1.dto.pessoa.PessoaDTOResponse;
import com.net.atividade1.dto.pessoa.PessoaDocumentoDTORequest;
import com.net.atividade1.mapper.DocumentoMapper;
import com.net.atividade1.mapper.PessoaMapper;
import com.net.atividade1.model.Documento;
import com.net.atividade1.model.Pessoa;
import com.net.atividade1.repository.DocumentoRepository;
import com.net.atividade1.repository.PessoaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PessoaService {
    private final DocumentoRepository documentoRepository;
    private final DocumentoMapper documentoMapper;
    
    private final PessoaRepository pessoaRepository;
    private final PessoaMapper pessoaMapper;

    public List<PessoaDTOResponse> index(){


        List<Pessoa> pessoas = pessoaRepository.findAll();

        return pessoas.stream()
                .map(pessoa -> {
                    Documento documento =  documentoRepository.findById(pessoa.getId())
                            .orElseThrow(() -> new RuntimeException("Documento não encontrado"));

                    return new PessoaDTOResponse(pessoa.getId(), pessoa.getNome(),
                            new DocumentoDTOResponse(documento.getId(), documento.getNumero(), documento.getTipo())
                    );
                })
                .toList();
    }

    public PessoaDTOResponse save(PessoaDocumentoDTORequest request){

        Boolean existsDocumento = documentoRepository.existsByNumeroAndTipo(request.documento().numero(), request.documento().numero());

        if(existsDocumento){
            throw new RuntimeException("O documento já existe!");
        }

        Documento documento = documentoMapper.toEntity(request.documento());
        Pessoa pessoa = pessoaMapper.toEntity(request);
        pessoa.setDocumento(documento);

        Pessoa pessoaDatabase = pessoaRepository.save(pessoa);

        return pessoaMapper.toResponse(pessoaDatabase);
    }

    public PessoaDTOResponse findById(Long id){
        Pessoa pessoaDatabase = pessoaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        return pessoaMapper.toResponse(pessoaDatabase);
    }

//    public PessoaDTOResponse update(Long id, PessoaDocumentoDTORequest request){
//
//    }
//
//    public void delete(Long id){
//
//    }
}
