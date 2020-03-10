package br.com.totvs.sistemaescolar.core.amqp;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface SistemaEscolaExchangeInput {
	
	public static final String INPUT = "sistema_escolar-input-events";
	
	@Input(SistemaEscolaExchangeInput.INPUT)
	SubscribableChannel inputEvent();
}
