package br.com.totvs.sistemaescolar.core.pessoa.exception;

import com.totvs.tjf.api.context.stereotype.error.ApiBadRequest;

@ApiBadRequest("CpfDeveSerValidoException")
public class CpfDeveSerValidoException extends RuntimeException {

	private static final long serialVersionUID = -7324840181798856779L;

}
