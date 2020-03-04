package br.com.totvs.sistemaescolar.core.disciplina.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CriarDisciplinaException")
public class CriarDisciplinaException extends ConstraintViolationException {

	private static final long serialVersionUID = 4289673635324646471L;

	public CriarDisciplinaException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}
}