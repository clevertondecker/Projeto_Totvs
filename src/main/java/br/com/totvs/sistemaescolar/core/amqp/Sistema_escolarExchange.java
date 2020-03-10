package br.com.totvs.sistemaescolar.core.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface Sistema_escolarExchange {

	public static final String OUTPUT = "sistema_escolar-output-events";
	
	@Output(Sistema_escolarExchange.OUTPUT)
	MessageChannel outputEvent();
	
}
