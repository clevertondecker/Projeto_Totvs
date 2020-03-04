package br.com.totvs.sistemaescolar.core.turma.api;

import javax.validation.constraints.NotNull;

import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Getter;

@Getter
public class CriarTurmaCommandDto {

	private TurmaId id;

	@NotNull(message = "{CriarTurmaCommandDto.decricao.NotNull}")
	private String descricao;

	@NotNull(message = "{CriarTurmaCommandDto.anoLetivo.NotNull}")
	private int anoLetivo;

	@NotNull(message = "{CriarTurmaCommandDto.periodoLetivo.NotNull}")
	private int periodoLetivo;

	@NotNull(message = "{CriarTurmaCommandDto.numeroVagas.NotNull}")
	private int numeroVagas;

	private String alunoId;
	private String disciplinaId;

}
