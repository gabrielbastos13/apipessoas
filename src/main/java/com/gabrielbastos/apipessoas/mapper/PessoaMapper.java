package com.gabrielbastos.apipessoas.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.gabrielbastos.apipessoas.dto.request.PessoaDTO;
import com.gabrielbastos.apipessoas.entity.Pessoa;

@Mapper
public interface PessoaMapper {
	
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyy")
	Pessoa toModel(PessoaDTO pessoaDTO);
	
	PessoaDTO toPessoa(Pessoa pessoa);

}
