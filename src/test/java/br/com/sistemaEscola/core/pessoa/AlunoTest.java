package br.com.sistemaEscola.core.pessoa;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;
import br.com.totvs.sistemaescolar.core.turma.domain.model.TurmaId;

public class AlunoTest {
	
	private AlunoId alunoId = AlunoId.generate();
	private String nome = "dev";
	private CPF cpf= CPF.of("18507288014");
	private String email = "logistica@totvs.com.br";
	private Long matricula = 12323L;
	private TurmaId turmaId = TurmaId.generate(); 
	
	private Aluno newOperador() {
		return Aluno.builder()
				.id(alunoId)
				.email(email)
				.nome(nome)
				.cpf(cpf)
				.matricula(matricula)
				.
				.build();
	}
}
