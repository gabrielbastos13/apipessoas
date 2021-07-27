package com.gabrielbastos.apipessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabrielbastos.apipessoas.entity.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
