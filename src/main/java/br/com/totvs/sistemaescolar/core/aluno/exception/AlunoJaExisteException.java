package br.com.totvs.sistemaescolar.core.aluno.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("AlunoJaExisteException")
public class AlunoJaExisteException extends ConstraintViolationException {

	private static final long serialVersionUID = 3625949091238061195L;

	public AlunoJaExisteException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}
}