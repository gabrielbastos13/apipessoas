package com.gabrielbastos.apipessoas.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum TipoTelefone {
	
	CASA("Casa"),
	CELULAR("Celular"),
	COMERCIAL("Comercial");
	
	private final String descricao;	
}
