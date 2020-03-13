package br.com.totvs.sistemaescolar.core.professor.domain.model;

import java.util.ArrayList;
import java.util.List;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.totvs.sistemaescolar.core.disciplina.domain.model.DisciplinaId;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.Pessoa;
import br.com.totvs.sistemaescolar.core.professor.enums.Titulacao;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Getter
@Aggregate
@NoArgsConstructor
public class Professor extends Pessoa {

	@AggregateIdentifier
	private ProfessorId id;
	private Titulacao titulo;

	@Builder
	public Professor(@NonNull ProfessorId id, String nome, String email, CPF cpf, Titulacao titulo, List<DisciplinaId> disciplina) {
		super(nome, email, cpf);
		this.id = id;
		this.titulo = titulo;
	}
	
}
