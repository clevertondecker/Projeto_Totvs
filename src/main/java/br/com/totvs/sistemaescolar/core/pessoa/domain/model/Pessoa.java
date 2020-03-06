package br.com.totvs.sistemaescolar.core.pessoa.domain.model;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@Aggregate
@NoArgsConstructor
public abstract class Pessoa {

	private String nome;
	private String email;
	@AggregateIdentifier
	private CPF cpf;

	public Pessoa(String nome, String email, CPF cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

}
