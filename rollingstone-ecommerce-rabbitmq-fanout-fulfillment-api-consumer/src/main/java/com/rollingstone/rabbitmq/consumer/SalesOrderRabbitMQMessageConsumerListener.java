package com.rollingstone.rabbitmq.consumer;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rollingstone.model.Address;
import com.rollingstone.model.Fulfillment;
import com.rollingstone.model.ItemMaster;
import com.rollingstone.model.SalesOrderDTO;
import com.rollingstone.service.FulfillmentService;

@Service
public class SalesOrderRabbitMQMessageConsumerListener {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderRabbitMQMessageConsumerListener.class);

	private FulfillmentService fulfillmentService;

	public SalesOrderRabbitMQMessageConsumerListener(FulfillmentService fulfillmentService) {
		this.fulfillmentService = fulfillmentService;
	}

	@RabbitListener(queues = "${fulfillment.queue.name}")
	public void receiveMessageForFinanceConsumerFromSalesProducer(final SalesOrderDTO salesOrderDTO) {
		LOG.info("Received message from Sales Order Producer Application: " + salesOrderDTO.toString());
		try {
			this.retrievedDataForFulfillmentAndSave(salesOrderDTO);
		} catch (Exception e) {
			LOG.error("Exception occurred during message receipt and processing: " + e.getLocalizedMessage());
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

	private void retrievedDataForFulfillmentAndSave(SalesOrderDTO salesOrderDTO) {
		String fulfillmentNumber = "FULFILLMENT-" + salesOrderDTO.getOrderNumber();
		String orderNumber = salesOrderDTO.getOrderNumber();
		String specialInstruction = salesOrderDTO.getSpecialInstruction();
		String shippingMethod = salesOrderDTO.getShippingMethod();
		Date estimatedDeliveryDate = salesOrderDTO.getEstimatedDeliveryDate();
		ItemMaster item = salesOrderDTO.getItem();
		String itemUpcCode = item.getItemUPCCode();
		String itemName = item.getItemName();
		Integer itemQuantity = salesOrderDTO.getItemQuantity();
		String color = item.getItemColor();
		String size = item.getItemSize();
		String shippedBy = item.getShippedBy();
		Address address = salesOrderDTO.getAddress();
		String shippingAddress = salesOrderDTO.getAccount().getUser().getFirstName() + " "
				+ salesOrderDTO.getAccount().getUser().getLastName() + " " + address.getHouseNumber() + " "
				+ address.getStreetAddress() + " " + address.getCity() + " " + address.getState() + " "
				+ address.getZipCode();
		Fulfillment fulfillment = new Fulfillment(fulfillmentNumber, orderNumber, specialInstruction, shippingMethod,
				estimatedDeliveryDate, itemUpcCode, itemName, itemQuantity.toString(), color, size, shippedBy,
				shippingAddress);
		this.fulfillmentService.save(fulfillment);
	}
}
