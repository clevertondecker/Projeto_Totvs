package br.com.totvs.sistemaescolar.core.pessoa.domain.model;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.CPF;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
public abstract class Pessoa {

	private String nome;
	private String email;
	private CPF cpf;

	public Pessoa(String nome, String email, CPF cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

}
