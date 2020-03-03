package br.com.totvs.sistemaescolar.core.aluno.api;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CpfCommandDto {

	@NotNull(message = "{CpfCommandDto.numero.NotNull}")
	@Size(min = 11, max = 11, message = "{CpfCommandDto.numero.Size}")
	private String numero;
}