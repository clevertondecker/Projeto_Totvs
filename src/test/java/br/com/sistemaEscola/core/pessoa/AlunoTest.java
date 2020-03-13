package br.com.sistemaEscola.core.pessoa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.Aluno;
import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;
import br.com.totvs.sistemaescolar.core.aluno.enums.formaDeIngresso;
import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;

public class AlunoTest {

	private AlunoId alunoId = AlunoId.generate();
	private String nome = "dev";
	private CPF cpf = CPF.of("18507288014");
	private String email = "logistica@totvs.com.br";
	private Long matricula = 12323L;
	private formaDeIngresso formaIngresso = formaDeIngresso.ENADE;

	private Aluno newAluno() {
		return Aluno.builder().id(alunoId).email(email).nome(nome).cpf(cpf).matricula(matricula)
				.formaIngresso(formaIngresso).build();
	}

	@Test
	public void alunoDeveBuildar() {
		Aluno aluno = this.newAluno();
		assertNotNull(aluno);
		assertEquals(aluno.getId(), alunoId);
		assertEquals(aluno.getEmail(), email);
		assertEquals(aluno.getNome(), nome);
		assertEquals(aluno.getCpf(), cpf);
		assertEquals(aluno.getMatricula(), matricula);
		assertEquals(aluno.getFormaIngresso(), formaIngresso);
	}

}
