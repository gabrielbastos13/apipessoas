package com.gabrielbastos.apipessoas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.gabrielbastos.apipessoas.dto.MessageResponseDTO;
import com.gabrielbastos.apipessoas.entity.Pessoa;
import com.gabrielbastos.apipessoas.repository.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}
	
	public MessageResponseDTO criarPessoa(Pessoa pessoa){
		Pessoa pessoaSalva = pessoaRepository.save(pessoa);
		return MessageResponseDTO
				.builder()
				.message("Pessoa criada com o ID: " + pessoaSalva.getId())
				.build();
	}
}
