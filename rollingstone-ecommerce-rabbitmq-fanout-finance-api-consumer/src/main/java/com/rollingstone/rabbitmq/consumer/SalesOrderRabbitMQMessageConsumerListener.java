package com.rollingstone.rabbitmq.consumer;

import java.math.BigDecimal;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import com.rollingstone.model.AccountReceivable;
import com.rollingstone.model.SalesOrderDTO;
import com.rollingstone.service.AccountReceivableService;

@Service
public class SalesOrderRabbitMQMessageConsumerListener {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderRabbitMQMessageConsumerListener.class);

	private AccountReceivableService accountReceivableService;

	public SalesOrderRabbitMQMessageConsumerListener(AccountReceivableService accountReceivableService) {
		this.accountReceivableService = accountReceivableService;
	}

	@RabbitListener(queues = "${account-receivable.queue.name}")
	public void receiveMessageForFinanceConsumerFromSalesProducer(final SalesOrderDTO salesOrderDTO) {
		LOG.info("Received message from Sales Order Producer Application: " + salesOrderDTO.toString());

		try {
			this.retrievedDataForAccountReceivable(salesOrderDTO);
		} catch (Exception e) {
			LOG.error("Exception occurred during message receipt and processing: " + e.getLocalizedMessage());
			throw new AmqpRejectAndDontRequeueException(e);
		}
	}

	private void retrievedDataForAccountReceivable(SalesOrderDTO salesOrderDTO) {
		String transactionNumber = "TRNSLS" + salesOrderDTO.getOrderNumber();
		Long accountId = salesOrderDTO.getAccount().getId();
		Long userId = salesOrderDTO.getAccount().getUser().getId();
		Long salesOrderId = salesOrderDTO.getId();
		Date transactionDate = salesOrderDTO.getSalesDate();
		BigDecimal transactionAmount = salesOrderDTO.getTotalOrderAmount();
		Long salesRepId = salesOrderDTO.getEmployee().getId();
		AccountReceivable accountReceivable = new AccountReceivable(transactionNumber, accountId, userId, salesOrderId,
				transactionDate, transactionAmount, salesRepId);
		this.accountReceivableService.save(accountReceivable);
	}
}
