package com.fatec.pessoa_api.repository;

import com.fatec.pessoa_api.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
