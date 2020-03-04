package br.com.totvs.sistemaescolar.core.aluno.api;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarAlunoCommand {

	private final AlunoId id;
	private final String nome;
	private final String email;
	private final CPF cpf;
	private final formaDeIngresso formaIngresso;
	private final Long matricula;
	private final String turma;

	public static CriarAlunoCommand of(String nome, String email, CPF cpf, formaDeIngresso formaIngresso,
			long matricula, String turma) {
		return new CriarAlunoCommand(null, nome, email, cpf, formaIngresso, matricula, turma);
	}

}
