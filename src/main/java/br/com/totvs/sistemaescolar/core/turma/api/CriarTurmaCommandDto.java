package br.com.totvs.sistemaescolar.core.turma.api;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.disciplina.Disciplina;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Getter;

@Getter
public class CriarTurmaCommandDto {

	private TurmaId id;

	@NotNull(message = "{CriarTurmaCommandDto.matricula.NotNull}")
	private String decricao;
	
	@NotNull(message = "{CriarTurmaCommandDto.anoLetivo.NotNull}")
	private int anoLetivo;
	
	@NotNull(message = "{CriarTurmaCommandDto.periodoLetivo.NotNull}")
	private int periodoLetivo;
	
	@NotNull(message = "{CriarTurmaCommandDto.numeroVagas.NotNull}")
	private int numeroVagas;

	private Optional<Aluno> aluno;
	private Optional<Disciplina> disciplina;


}
