package com.net.empresa.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "departamento")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer piso;

    @OneToMany(mappedBy = "departamento")
    private List<Funcionario> funcionarios;

    public Departamento(String nome, Integer piso) {
        this.nome = nome;
        this.piso = piso;
    }
}
