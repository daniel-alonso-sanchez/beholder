package org.bringer.tools.beholder.applications.config;


import org.bringer.tools.beholder.applications.component.RabbitMqApplicationsProducer;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class EventProducerConfiguration {
	@Bean
	public Exchange eventExchange() {
		return new FanoutExchange("applications");
	}

	@Bean
	public RabbitMqApplicationsProducer customerService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
		return new RabbitMqApplicationsProducer(rabbitTemplate, eventExchange());
	}
}
