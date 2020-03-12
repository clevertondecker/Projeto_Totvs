package br.com.totvs.sistemaescolar.core.amqp;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface YMSExchange {

	public static final String OUTPUT = "yms-output-events";
	
	@Output(YMSExchange.OUTPUT)
	MessageChannel outputEvent();
	
}
