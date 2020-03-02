package br.com.totvs.sistemaescolar.aluno.entity;

import com.totvs.tjf.core.stereotype.Aggregate;
import com.totvs.tjf.core.stereotype.AggregateIdentifier;

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
//  @NotNull(message = "Please enter matricula")
	private Long matricula;
//	@NotNull
//  @Length(min = 1, message = "Forma de ingresso")
	private String formaIngresso;

	@Builder
	public Aluno(@NonNull AlunoId id,String nome, String email, String cpf, Long matricula, String formaIngresso) {
		super(nome, email, cpf);
		this.id = id;
		this.matricula = matricula;
		this.formaIngresso = formaIngresso;
	}

	@Override
	public String toString() {
		return "Aluno [id=" + id + ", matricula=" + matricula + ", formaIngresso=" + formaIngresso + ", Nome()="
				+ getNome() + ", Email()=" + getEmail() + ", Cpf()=" + getCpf() + "]";
	}
	

}
