package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
public class SalesOrderMessageSender {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderMessageSender.class);
	
	public void sendMessage(RabbitTemplate rabbitTemplate, String salesOrderExchange, String salesOrderRoutingKey, Object salesOrderData) {
		LOG.info("Sending message to the Sales Order Exchange, Message = {} ", salesOrderData);
		rabbitTemplate.convertAndSend(salesOrderExchange, salesOrderRoutingKey, salesOrderData);
		LOG.info("The Sales Order Message was sent");
	}
}
