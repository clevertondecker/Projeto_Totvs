package br.com.totvs.sistemaescolar.core.amqp;

import java.lang.reflect.Field;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;

import com.totvs.tjf.core.message.TOTVSMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@EnableBinding(YMSExchange.class)
public class YMSPublisher {
	
	private static final Logger LOG = LoggerFactory.getLogger(YMSPublisher.class);
	
	private YMSExchange ymsExchange;
	
	public YMSPublisher(YMSExchange ymsExchange) {
		this.ymsExchange = ymsExchange;
	}
	
	public <T> void publish(T event) {
		Field field;
		String eventName = null;
		try {
			field = event.getClass().getField("NAME");
			eventName = (String) field.get(event);
			
			LOG.info("DEU BOA", event ,"event name", eventName);
			new TOTVSMessage<T>(eventName, event).sendTo(ymsExchange.outputEvent());
			
		} catch (Exception e) {
			LOG.debug("Exchange: {}\nTopic: {}\n", ymsExchange, eventName);
		}		
	}
}
