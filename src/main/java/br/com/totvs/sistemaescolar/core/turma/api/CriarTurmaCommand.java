package br.com.totvs.sistemaescolar.core.turma.api;

import java.util.List;

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

	private final List<AlunoId> alunoId;
	private final List<DisciplinaId> disciplinaId;

	public static CriarTurmaCommand of(String decricao, int anoLetivo, int periodoLetivo, int numeroVagas,
			List<AlunoId> alunoid, List<DisciplinaId> disciplinaId) {
		return new CriarTurmaCommand(null, decricao, anoLetivo, periodoLetivo, numeroVagas, alunoid, disciplinaId);
	}

}
