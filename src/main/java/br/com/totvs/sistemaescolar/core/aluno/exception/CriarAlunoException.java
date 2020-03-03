package br.com.totvs.sistemaescolar.core.aluno.exception;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;


@ApiBadRequest("CriarAlunoException")
public class CriarAlunoException extends ConstraintViolationException {

	private static final long serialVersionUID = 7686045486654120992L;

	public CriarAlunoException(Set<? extends ConstraintViolation<?>> constraintViolations) {
			super(constraintViolations);
		}
}