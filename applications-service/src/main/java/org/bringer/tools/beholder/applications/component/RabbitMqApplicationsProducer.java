package org.bringer.tools.beholder.applications.component;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;


public class RabbitMqApplicationsProducer implements IApplicationsProducer {
	private RabbitTemplate rabbitTemplate;
	private Exchange eventExchange;

	@Autowired
	public RabbitMqApplicationsProducer(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
		super();
		this.rabbitTemplate = rabbitTemplate;
		this.eventExchange = eventExchange;
	}

	@Override
	public void notifyApplicationCreated(String uuid, String name, String url) {
		  String routingKey = "application.created";
		  String message = "%s,%s,%s";
		 
		  rabbitTemplate.convertAndSend(eventExchange.getName(), routingKey,  String.format(message, uuid,name,url));
	}

}
