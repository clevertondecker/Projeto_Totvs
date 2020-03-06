package br.com.totvs.sistemaescolar.core.aluno.domain.model;



import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.Pessoa;
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
	

	@Builder
	public Aluno(@NonNull AlunoId id, String nome, String email, CPF cpf, Long matricula,
			formaDeIngresso formaIngresso) {
		super(nome, email, cpf);
		this.id = id;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

}
