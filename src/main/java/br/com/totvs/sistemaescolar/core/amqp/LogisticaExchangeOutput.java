package br.com.totvs.sistemaescolar.core.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface LogisticaExchangeOutput {

	public static final String OUTPUT = "logistica-output-events";
	
	@Output(LogisticaExchangeOutput.OUTPUT)
	MessageChannel outputEvent();
}
