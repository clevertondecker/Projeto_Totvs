package br.com.totvs.sistemaescolar.core.turma.api;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarTurmaCommand {

	private final TurmaId id;
	private final String decricao;
	private final int anoLetivo;
	private final int periodoLetivo;
	private final int numeroVagas;

	private final AlunoId alunoId;
	private final DisciplinaId disciplinaId;

	public static CriarTurmaCommand of(String decricao, int anoLetivo, int periodoLetivo, int numeroVagas,
			AlunoId alunoid, DisciplinaId disciplinaId) {
		return new CriarTurmaCommand(null, decricao, anoLetivo, periodoLetivo, numeroVagas, alunoid, disciplinaId);
	}

}
