package br.com.totvs.sistemaescolar.core.disciplina.api;

import java.util.List;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.professor.domain.model.ProfessorId;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarDisciplinaCommand {

	private final DisciplinaId id;
	private final String descricao;
	private final String sigla;
	private final int cargaHoraria;

	private final List<TurmaId> turmaId;
	private final List<ProfessorId>professorId;

	public static CriarDisciplinaCommand of(String sigla,String descricao, int cargaHoraria, List<TurmaId> turma, List<ProfessorId> professor) {
		return new CriarDisciplinaCommand(null, sigla, descricao, cargaHoraria, turma, professor);
	}

}
