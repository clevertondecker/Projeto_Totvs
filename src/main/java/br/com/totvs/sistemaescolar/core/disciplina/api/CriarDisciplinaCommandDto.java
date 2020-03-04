package br.com.totvs.sistemaescolar.core.disciplina.api;

import javax.validation.constraints.NotNull;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import lombok.Getter;

@Getter
public class CriarDisciplinaCommandDto {

	private DisciplinaId id;
	
	@NotNull(message = "{CriarDisciplinaCommandDto.descricao.NotNull}")
	private String descricao;
	
	@NotNull(message = "{CriarDisciplinaCommandDto.sigla.NotNull}")
	private String sigla;
	
	@NotNull(message = "{CriarDisciplinaCommandDto.cargaHoraria.NotNull}")
	private int cargaHoraria;
	
	private String turma;
	
	private String professor;

	
}
