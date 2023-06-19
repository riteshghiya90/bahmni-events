package org.bahmni.module.events.publisher;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.bahmni.module.events.model.Event;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.context.event.EventListener;
import org.springframework.jms.core.JmsTemplate;

import javax.jms.Message;
import java.io.IOException;

public class EventPublisher {
	
	private static final Logger log = LogManager.getLogger(EventPublisher.class);
	
	private final JmsTemplate jmsTemplate;
	
	private final ObjectMapper objectMapper = new ObjectMapper();
	
	public EventPublisher(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	@EventListener
    public void onApplicationEvent(Event event) {
		String jsonPayload = toJsonPayload(event);
		jmsTemplate.send(event.eventType, session -> session.createTextMessage(jsonPayload));
        log.info("Published Message" + event.eventType +  " : " + event.eventId + " : " + event.payloadId);
        System.out.println("Published Message" + event.eventType +  " : " + event.eventId + " : " + jsonPayload);
    }
	
	private String toJsonPayload(Event event) {
		String payload;
		try {
			payload = objectMapper.writeValueAsString(event);
		}
		catch (IOException exception) {
			log.error("Error while creating event payload : ", exception);
			throw new RuntimeException(exception);
		}
		return payload;
	}
}
