package br.com.totvs.sistemaescolar.core.aluno.api;


import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarAlunoCommand {

	private final AlunoId id;
	private final String nome;
	private final String email;
	private final String cpf;
	private final formaDeIngresso formaIngresso;
	private final Long matricula;



}
