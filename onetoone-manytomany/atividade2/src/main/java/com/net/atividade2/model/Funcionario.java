package com.net.atividade2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="funcionario")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Funcionario {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String nome;

    @OneToOne(mappedBy = "funcionario", orphanRemoval = true, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Endereco endereco;

    public Funcionario(String nome) {
        this.nome = nome;
    }
}
