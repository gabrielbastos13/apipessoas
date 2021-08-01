package com.gabrielbastos.apipessoas.dto.request;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


import com.gabrielbastos.apipessoas.entity.Telefone;
import com.gabrielbastos.apipessoas.enums.TipoTelefone;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor 
@NoArgsConstructor
public class TelefoneDTO {
	
	private Long id;
	
	@Enumerated(EnumType.STRING)
	private TipoTelefone tipo;

	@NotEmpty
	@Size(min = 13, max = 14)
	private String numero;
	
}
