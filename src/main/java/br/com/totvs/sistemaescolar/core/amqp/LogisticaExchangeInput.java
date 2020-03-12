package br.com.totvs.sistemaescolar.core.amqp;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface LogisticaExchangeInput {

	public static final String INPUT = "logistica-input-events";
	
	@Input(LogisticaExchangeInput.INPUT)
	SubscribableChannel inputEvent();
}
