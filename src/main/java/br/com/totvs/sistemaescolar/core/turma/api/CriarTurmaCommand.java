package br.com.totvs.sistemaescolar.core.turma.api;


import java.util.Optional;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.disciplina.Disciplina;
import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarTurmaCommand {

	private final TurmaId id;
	private final String decricao;
	private final int anoLetivo;
	private final int periodoLetivo;
	private final int numeroVagas;
	
	private final Optional<Aluno> aluno;
	private final Optional<Disciplina> disciplina;

	public static CriarTurmaCommand of(String decricao,int anoLetivo, int periodoLetivo, int numeroVagas, Optional<Aluno> aluno, Optional<Disciplina> disciplina) {
		return new CriarTurmaCommand(null, decricao, anoLetivo, periodoLetivo, numeroVagas, aluno, disciplina);
	}


}
