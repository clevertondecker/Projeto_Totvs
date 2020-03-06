package br.com.sistemaEscola.core.aluno.domain;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;

public class AlunoTest {

	private Aluno newAluno() {
		return Aluno.builder()
				.nome("Cleverton")
				.email("Cleverton@Decker.com")
				.cpf(CPF.of("09393481954"))
				.id(AlunoId.generate())
				.matricula(2233l)
				.formaIngresso(formaDeIngresso.ENADE)
				.build();
	}
	
	@Test
	public void AlunoDeveBuildar() {
		Aluno aluno = this.newAluno();
		assertNotEquals(aluno, null);
	}
	


}
