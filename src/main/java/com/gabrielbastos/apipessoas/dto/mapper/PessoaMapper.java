package com.gabrielbastos.apipessoas.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.gabrielbastos.apipessoas.dto.request.PessoaDTO;
import com.gabrielbastos.apipessoas.entity.Pessoa;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
	
	PessoaMapper INSTANCE = Mappers.getMapper(PessoaMapper.class);
	
    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Pessoa toModel(PessoaDTO pessoaDTO);
	
	PessoaDTO toPessoa(Pessoa pessoa);

}
