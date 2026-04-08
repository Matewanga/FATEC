package com.fatec.pessoa_api.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String telefone;
}
