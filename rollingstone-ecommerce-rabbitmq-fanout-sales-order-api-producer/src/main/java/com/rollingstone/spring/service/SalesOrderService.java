package com.rollingstone.spring.service;

import org.springframework.data.domain.Page;

import com.rollingstone.spring.model.SalesOrder;
import com.rollingstone.spring.model.SalesOrderDTO;

public interface SalesOrderService {

	SalesOrder save(SalesOrder salesOrder);
	
	SalesOrderDTO getSalesOrder(long id);
	
	Page<SalesOrder> getSalesOrderByPage(Integer pageNumber, Integer pageSize);
	
	void update(SalesOrder salesOrder);
	
	void delete(long id);
}
