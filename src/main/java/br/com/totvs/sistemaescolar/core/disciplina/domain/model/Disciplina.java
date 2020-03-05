package br.com.totvs.sistemaescolar.core.disciplina.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.totvs.sistemaescolar.core.professor.domain.model.Professor;
import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Aggregate
@NoArgsConstructor
public class Disciplina {

	@AggregateIdentifier
	private DisciplinaId id;
	private String descricao;
	private String sigla;
	private int cargaHoraria;

	List<Professor> professores = new ArrayList<>();
	List<Turma> turmas = new ArrayList<>();

	@Builder
	public Disciplina(@NonNull DisciplinaId id, String descricao, String sigla, int cargaHoraria,
			List<Professor> professor, List<Turma> turma) {
		this.id = id;
		this.descricao = descricao;
		this.sigla = sigla;
		this.cargaHoraria = cargaHoraria;
		this.professores = professor;
		this.turmas = turma;
	}

}
