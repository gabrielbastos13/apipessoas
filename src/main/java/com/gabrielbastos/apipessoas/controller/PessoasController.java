package com.gabrielbastos.apipessoas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.gabrielbastos.apipessoas.dto.MessageResponseDTO;
import com.gabrielbastos.apipessoas.dto.request.PessoaDTO;
import com.gabrielbastos.apipessoas.entity.Pessoa;
import com.gabrielbastos.apipessoas.repository.PessoaRepository;
import com.gabrielbastos.apipessoas.service.PessoaService;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoasController {

	private PessoaService pessoaService;
	
	@Autowired
	public PessoasController(PessoaService pessoaService) {
		super();
		this.pessoaService = pessoaService;
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO criarPessoa(@RequestBody @Valid PessoaDTO pessoaDTO) {
		return pessoaService.criarPessoa(pessoaDTO);
	}
	
	@GetMapping
	public List<PessoaDTO> listarTodos() {
		return pessoaService.listAll();
	}
	
	@GetMapping("/{id}")
	public PessoaDTO listarPorID(@PathVariable Long id) {
		return pessoaService.findById(id);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarPorId(@PathVariable Long id) {
		pessoaService.delete(id);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO atualizarPessoaPorId(@PathVariable Long id, @RequestBody @Valid PessoaDTO pessoaDTO) { 
		return pessoaService.updateByID(id, pessoaDTO);
	
	}
}
