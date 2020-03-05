package br.com.totvs.sistemaescolar.core.aluno.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.Pessoa;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Aggregate
@NoArgsConstructor
public class Aluno extends Pessoa {

	@AggregateIdentifier
	private AlunoId id;
	private Long matricula;
	private formaDeIngresso formaIngresso;
	
	private List<TurmaId> turmas = new ArrayList<>();

	@Builder
	public Aluno(@NonNull AlunoId id, String nome, String email, CPF cpf, Long matricula,
			formaDeIngresso formaIngresso, List<TurmaId> turmaId) {
		super(nome, email, cpf);
		this.id = id;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
		
		if(turmaId !=null)
		this.turmas.addAll(turmaId);
	}

}
