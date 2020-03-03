package br.com.totvs.sistemaescolar.core.aluno.exception;


import com.totvs.tjf.api.context.stereotype.ApiErrorParameter;
import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;


@ApiBadRequest("VerificaCPFAlunoException")
public class VerificaCPFAlunoException extends RuntimeException {

	private static final long serialVersionUID = 2451552095592378105L;

	@ApiErrorParameter
	private final String cpf;
	
	public VerificaCPFAlunoException(String cfp) {
		this.cpf = cfp;
	}
}