package com.net.atividade1.dto.pessoa;

import com.net.atividade1.dto.documento.DocumentoDTORequest;
import com.net.atividade1.dto.documento.DocumentoDTOResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PessoaDocumentoDTORequest(
        @NotBlank
        String nome,

        @Valid
        DocumentoDTORequest documento

) {
}
