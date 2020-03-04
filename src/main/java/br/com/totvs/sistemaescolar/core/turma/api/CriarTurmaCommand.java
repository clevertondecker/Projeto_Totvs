package br.com.totvs.sistemaescolar.core.turma.api;

import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarTurmaCommand {

	private final TurmaId id;
	private final String decricao;
	private final int anoLetivo;
	private final int periodoLetivo;
	private final int numeroVagas;

	private final String alunoId;
	private final String disciplinaId;

	public static CriarTurmaCommand of(String decricao, int anoLetivo, int periodoLetivo, int numeroVagas,
			String alunoid, String disciplinaId) {
		return new CriarTurmaCommand(null, decricao, anoLetivo, periodoLetivo, numeroVagas, alunoid, disciplinaId);
	}

}
