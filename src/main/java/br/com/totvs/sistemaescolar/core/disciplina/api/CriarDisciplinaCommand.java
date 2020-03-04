package br.com.totvs.sistemaescolar.core.disciplina.api;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarDisciplinaCommand {

	private final DisciplinaId id;
	private final String descricao;
	private final String sigla;
	private final int cargaHoraria;

	private final String turma;
	private final String professor;

	public static CriarDisciplinaCommand of(String sigla,String descricao, int cargaHoraria, String turma, String professor) {
		return new CriarDisciplinaCommand(null, sigla, descricao, cargaHoraria, turma, professor);
	}

}
