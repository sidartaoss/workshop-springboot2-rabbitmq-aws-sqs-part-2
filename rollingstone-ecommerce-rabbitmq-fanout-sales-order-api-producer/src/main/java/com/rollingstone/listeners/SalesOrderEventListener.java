package com.rollingstone.listeners;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.rollingstone.events.SalesOrderEvent;

@Component
public class SalesOrderEventListener {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderEventListener.class);

	private RabbitTemplate rabbitTemplate;
	private SalesOrderMessageSender salesOrderMessageSender;

	@Value("${sales-order.exchange.name}")
	private String salesOrderExchangeName;

	@Value("${sales-order.routing.key}")
	private String salesOrderRoutingKey;

	public SalesOrderEventListener(RabbitTemplate rabbitTemplate, Exchange exchange,
			SalesOrderMessageSender salesOrderMessageSender) {
		this.rabbitTemplate = rabbitTemplate;
		this.salesOrderMessageSender = salesOrderMessageSender;
	}

	@EventListener
	public void onApplicationEvent(SalesOrderEvent salesOrderEvent) {
		LOG.info("Received Sales Order Event: {} ", salesOrderEvent.getEventType());
		LOG.info("Received Sales Order from Sales Order Event: {} ", salesOrderEvent.getSalesOrderDTO().toString());
		LOG.info("Sales Order created with ID: " + salesOrderEvent.getSalesOrderDTO().getOrderNumber()
				+ " and Total Order Amount: " + salesOrderEvent.getSalesOrderDTO().getTotalOrderAmount());
		LOG.info("Printing Sales Order Details Data before sending message: " + salesOrderEvent.getSalesOrderDTO());
		this.salesOrderMessageSender.sendMessage(rabbitTemplate, salesOrderExchangeName, salesOrderRoutingKey,
				salesOrderEvent.getSalesOrderDTO());
	}

}
