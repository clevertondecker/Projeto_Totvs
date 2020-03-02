package br.com.totvs.sistemaescolar.core.pessoa.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
public abstract class Pessoa {

	private String nome;
	private String email;
	private String cpf;

	public Pessoa(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

}
