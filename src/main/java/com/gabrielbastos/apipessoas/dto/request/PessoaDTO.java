package com.gabrielbastos.apipessoas.dto.request;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.br.CPF;

import com.gabrielbastos.apipessoas.entity.Pessoa;
import com.gabrielbastos.apipessoas.entity.Telefone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PessoaDTO {

	private Long id;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String nome;

	@NotEmpty
	@Size(min = 2, max = 100)
	private String sobrenome;

	@NotEmpty
	@CPF
	private String cpf;

	@NotNull
	private String birthDate;

	@Valid
	@NotEmpty
	private List<TelefoneDTO> telefones;

}
