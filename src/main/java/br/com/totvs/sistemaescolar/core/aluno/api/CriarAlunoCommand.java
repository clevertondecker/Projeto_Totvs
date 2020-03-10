package br.com.totvs.sistemaescolar.core.aluno.api;


import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;
import lombok.Data;

@Data(staticConstructor = "of")

public final class CriarAlunoCommand {

	private final AlunoId id;
	private final String nome;
	private final String email;
	private final CPF cpf;
	private final formaDeIngresso formaIngresso;
	private final Long matricula;
	private final TurmaId turmaId;

	public static CriarAlunoCommand of(String nome, String email, CPF cpf, formaDeIngresso formaIngresso,
			long matricula, TurmaId turmaId) {
		return new CriarAlunoCommand(null, nome, email, cpf, formaIngresso, matricula, turmaId);
	}
	
	public static CriarAlunoCommand fromIntegration(AlunoId id,String nome, String email, CPF cpf, formaDeIngresso formaIngresso,
			long matricula, TurmaId turmaId) {
		return new CriarAlunoCommand(id, nome, email, cpf, formaIngresso, matricula, turmaId);
	}

}
