package br.com.totvs.sistemaescolar.core.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface SistemaEscolaExchangeOutput {

	public static final String OUTPUT = "sistema_escolar-output-events";
	
	@Output(SistemaEscolaExchangeOutput.OUTPUT)
	MessageChannel outputEvent();
}
