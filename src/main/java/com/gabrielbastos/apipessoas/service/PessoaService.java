package com.gabrielbastos.apipessoas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gabrielbastos.apipessoas.dto.MessageResponseDTO;
import com.gabrielbastos.apipessoas.dto.request.PessoaDTO;
import com.gabrielbastos.apipessoas.entity.Pessoa;
import com.gabrielbastos.apipessoas.dto.mapper.PessoaMapper;
import com.gabrielbastos.apipessoas.repository.PessoaRepository;

@Service
public class PessoaService {

	private PessoaRepository pessoaRepository;
	
	private final PessoaMapper pessoaMapper = PessoaMapper.INSTANCE;

	@Autowired
	public PessoaService(PessoaRepository pessoaRepository) {
		super();
		this.pessoaRepository = pessoaRepository;
	}
	
	public MessageResponseDTO criarPessoa(PessoaDTO pessoaDTO){
		Pessoa pessoaParaSalvar = pessoaMapper.toModel(pessoaDTO);
		
		Pessoa pessoaSalva = pessoaRepository.save(pessoaParaSalvar);
		return MessageResponseDTO
				.builder()
				.message("Pessoa criada com o ID: " + pessoaSalva.getId())
				.build();
	}
	
	public List<PessoaDTO> listAll() {
		List<Pessoa> todasPessoas = pessoaRepository.findAll();
		
		return todasPessoas.stream()
				.map(pessoaMapper::toPessoa)
				.collect(Collectors.toList());
	}
	
	public PessoaDTO findById(Long id) {
		Optional<Pessoa> optionalPessoa = pessoaRepository.findById(id);
		return pessoaMapper.toPessoa(optionalPessoa.get());
	}
}
