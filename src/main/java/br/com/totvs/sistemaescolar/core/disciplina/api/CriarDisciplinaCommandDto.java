package br.com.totvs.sistemaescolar.core.disciplina.api;

import java.util.List;

import javax.validation.constraints.NotNull;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
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
	
	private List<TurmaId> turmaId;
	
	private List<ProfessorId> professorId;

	
}
