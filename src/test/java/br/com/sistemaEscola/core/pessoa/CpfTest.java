package br.com.sistemaEscola.core.pessoa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.totvs.sistemaescolar.core.pessoa.domain.model.CPF;



public class CpfTest {

	@Test
	public void deveConstruir() {
		CPF vo = CPF.of("09972487008");
		
		assertNotNull(vo);
		assertEquals("09972487008", vo.getNumero());
	}

	@Test
	public void deveRetornarCpfValido() {
		assertNotNull(CPF.of("87971813660").getNumero());
	}

	@Test
	public void deveRetornarCpfValidoDigito10() {
		assertNotNull(CPF.of("24821191709").getNumero());
	}

	@Test
	public void deveRetornarCpfValidoDigito11() {
		assertNotNull(CPF.of("57147885910").getNumero());
	}
	
	
}
