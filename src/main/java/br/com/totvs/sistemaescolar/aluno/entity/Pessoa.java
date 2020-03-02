package br.com.totvs.sistemaescolar.aluno.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data // lombok
@NoArgsConstructor
public abstract class Pessoa {

//	@NotNull
	private String nome;
	// @NotNull
	private String email;
//	@NotNull
	private String cpf;

	public Pessoa(String nome, String email, String cpf) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
	}

}
