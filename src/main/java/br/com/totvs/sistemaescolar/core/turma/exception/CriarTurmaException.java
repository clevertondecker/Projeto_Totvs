package br.com.totvs.sistemaescolar.core.turma.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CriarTurmaException")

public class CriarTurmaException extends ConstraintViolationException {

	private static final long serialVersionUID = 4289673635324646471L;

	public CriarTurmaException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}
}