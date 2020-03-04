package br.com.totvs.sistemaescolar.core.professor.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CriarProfessorException")
public class CriarProfessorException extends ConstraintViolationException {

	private static final long serialVersionUID = -589032680259954652L;

	public CriarProfessorException(Set<? extends ConstraintViolation<?>> constraintViolations) {
		super(constraintViolations);
	}
}