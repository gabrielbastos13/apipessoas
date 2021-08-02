package com.gabrielbastos.apipessoas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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

		MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", pessoaSalva.getId());

        return messageResponse;
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
	
	public MessageResponseDTO updateByID(Long id, PessoaDTO pessoaDTO) {
		 pessoaRepository.findById(id);
		
		Pessoa pessoaParaAtualizar = pessoaMapper.toModel(pessoaDTO);
		
		Pessoa pessoaAtualizada = pessoaRepository.save(pessoaParaAtualizar);
		

		MessageResponseDTO messageResponse = createMessageResponse("Person successfully updated with ID ", pessoaAtualizada.getId());

        return messageResponse;
        
    }
	

	 public void delete(Long id){
		 	pessoaRepository.findById(id);
	        pessoaRepository.deleteById(id);
	    }
	 
	 private MessageResponseDTO createMessageResponse(String s, Long id2) {
	        return MessageResponseDTO.builder()
	                .message(s + id2)
	                .build();
	    }
}
