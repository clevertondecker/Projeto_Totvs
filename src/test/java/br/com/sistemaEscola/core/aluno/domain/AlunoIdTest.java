package br.com.sistemaEscola.core.aluno.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.totvs.sistemaescolar.core.aluno.domain.model.AlunoId;


public class AlunoIdTest {

	@Test
	public void deveGerarUUIDFromString() {
		String id = "38400000-8cf0-11bd-b23e-10b96e4ef00d";
		
		AlunoId alunoId = AlunoId.fromString(id);
		assertEquals(alunoId.toString(), id);
	}
	
	@Test
	public void deveRetornarTipoString() {
		AlunoId id = AlunoId.generate();
		assertTrue(id.toString() instanceof String);
	}
	
	@Test
	public void deveGerarUUID() {
		AlunoId id = AlunoId.generate();
		assertNotNull(id);
	}
	
	
}
