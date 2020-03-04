package br.com.totvs.sistemaescolar.core.disciplina;


import java.util.ArrayList;
import java.util.List;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.totvs.sistemaescolar.core.professor.domain.model.Professor;
import br.com.totvs.sistemaescolar.core.turma.domain.model.Turma;
import lombok.Getter;

@Getter
@Aggregate
public class Disciplina {

	@AggregateIdentifier
	private DisciplinaId id;
	private String descricao;
	private String sigla;
	private int cargaHoraria;
	
	List<Professor> professores = new ArrayList<>();
	List<Turma> turma = new ArrayList<>();;

}
