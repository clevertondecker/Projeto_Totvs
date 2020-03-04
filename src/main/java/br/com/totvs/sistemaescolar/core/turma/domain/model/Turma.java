package br.com.totvs.sistemaescolar.core.turma.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.disciplina.Disciplina;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@NoArgsConstructor
@Aggregate
public class Turma {

	@AggregateIdentifier
	private TurmaId id;
	private String Descricao;
	private int anoLetivo;
	private int periodoLetivo;
	private int numeroVagas;
	
	
	List<Aluno> alunos = new ArrayList<>();
	List<Disciplina> disciplinas = new ArrayList<>();

	@Builder
	public Turma(@NonNull TurmaId id, String descricao, int anoLetivo, int periodoLetivo, int numeroVagas,List<Aluno> aluno, List<Disciplina> disciplina) {
		this.id = id;
		Descricao = descricao;
		this.anoLetivo = anoLetivo;
		this.periodoLetivo = periodoLetivo;
		this.numeroVagas = numeroVagas;
		this.disciplinas = disciplina;
		this.alunos = aluno;
	}
	

}