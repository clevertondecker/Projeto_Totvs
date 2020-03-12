package br.com.totvs.sistemaescolar.core.amqp;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.totvs.tjf.core.message.TOTVSMessage;

@EnableBinding(LogisticaExchangeOutput.class)
public class LogisticaPublisher {

	private static final Logger LOG = LoggerFactory.getLogger(LogisticaPublisher.class);
	
	private LogisticaExchangeOutput logisticaExchangeOutput;
	
	public LogisticaPublisher(LogisticaExchangeOutput logisticaExchangeOutput) {
		this.logisticaExchangeOutput = logisticaExchangeOutput;
	}
	
	public <T> void publish(T event) {
		Field field;
		String eventName = null;
		try {
			field = event.getClass().getField("NAME");
			eventName = (String) field.get(event);
			
			new TOTVSMessage<T>(eventName, event).sendTo(logisticaExchangeOutput.outputEvent());
			
		} catch (Exception e) {
			LOG.debug("Exchange: {}\nTopic: {}\n", logisticaExchangeOutput, eventName);
		}		
	}
}
