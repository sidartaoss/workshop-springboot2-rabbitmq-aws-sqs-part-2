package com.rollingstone.service;

import org.springframework.data.domain.Page;

import com.rollingstone.model.Fulfillment;

public interface FulfillmentService {

	Fulfillment save(Fulfillment fulfillment);
	
	Fulfillment getFulfillment(Long id);
	
	Page<Fulfillment> getFulfillmentByPage(Integer pageNumber, Integer pageSize);
	
	void update(Fulfillment fulfillment);
	
	void delete(Long id);
}
