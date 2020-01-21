package com.rollingstone.spring.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rollingstone.events.SalesOrderEvent;
import com.rollingstone.spring.model.SalesOrder;
import com.rollingstone.spring.model.SalesOrderDTO;
import com.rollingstone.spring.service.SalesOrderService;

@RestController
@RequestMapping(value = "/rscommerce/pdp-service")
public class SalesOrderController extends AbstractController {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderController.class);

	private SalesOrderService salesOrderService;

	public SalesOrderController(SalesOrderService salesOrderService) {
		this.salesOrderService = salesOrderService;
	}

	@PostMapping("/salesOrder")
	public ResponseEntity<?> createSalesOrder(@RequestBody SalesOrder salesOrder) {
		LOG.info("Entered in method createSalesOrder");
		SalesOrder savedSalesOrder = this.salesOrderService.save(salesOrder);
		LOG.info("Called salesOrderService.save: " + savedSalesOrder.toString());
		SalesOrderDTO sosDto = this.salesOrderService.getSalesOrder(savedSalesOrder.getId());
		LOG.info("salesOrderService.getSalesOrder: " + sosDto.toString());
		SalesOrderEvent salesOrderCreatedEvent = new SalesOrderEvent(this, "SalesOrderCreatedEvent", sosDto);
		LOG.info("Created an instance of SalesOrderEvent");
		this.eventPublisher.publishEvent(salesOrderCreatedEvent);
		LOG.info("Published an event with the object salesOrderCreatedEvent");
		return ResponseEntity.ok().body("The new sales order has been saved with ID: " + savedSalesOrder.getId());
	}

	@GetMapping("/salesOrder/{id}")
	public SalesOrderDTO getSalesOrder(@PathVariable("id") long id) {
		SalesOrderDTO sosDto = this.salesOrderService.getSalesOrder(id);
		SalesOrderEvent salesOrderRetrievedEvent = new SalesOrderEvent(this, "SalesOrderRetrievedEvent", sosDto);
		this.eventPublisher.publishEvent(salesOrderRetrievedEvent);
		return sosDto;
	}

	@PutMapping("salesOrder/{id}")
	public ResponseEntity<?> updateSalesOrder(@PathVariable("id") long id, @RequestBody SalesOrder salesOrder) {
		checkResourceFound(this.salesOrderService.getSalesOrder(id));
		this.salesOrderService.update(salesOrder);
		return ResponseEntity.ok().body("Sales Order has been updated successfully.");
	}

	@DeleteMapping("/salesOrder/{id}")
	public ResponseEntity<?> deleteSalesOrder(@PathVariable("id") long id) {
		checkResourceFound(this.salesOrderService.getSalesOrder(id));
		this.salesOrderService.delete(id);
		return ResponseEntity.ok().body("Sales Order has been deleted successfully.");
	}

}
