package com.rollingstone.spring.service;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.spring.dao.SalesOrderDaoRepository;
import com.rollingstone.spring.model.SalesOrder;
import com.rollingstone.spring.model.SalesOrderDTO;
import com.rollingstone.spring.model.SalesOrderDetails;

@Service
public class SalesOrderServiceImpl implements SalesOrderService {

	private static final Logger LOG = LoggerFactory.getLogger(SalesOrderServiceImpl.class);
	
	private SalesOrderDaoRepository salesOrderDaoRepository;
	
	public SalesOrderServiceImpl(SalesOrderDaoRepository salesOrderDaoRepository) {
		this.salesOrderDaoRepository = salesOrderDaoRepository;
	}
	
	@Override
	public SalesOrder save(SalesOrder salesOrder) {
		Set<SalesOrderDetails> soDetails = 	salesOrder.getSalesOrderDetails();
		
		for (SalesOrderDetails details : soDetails) {
			details.setSalesOrder(salesOrder);
		}
		
		return this.salesOrderDaoRepository.save(salesOrder);
	}

	@Override
	public SalesOrderDTO getSalesOrder(long id) {
		LOG.info("Inside getSalesOrder");
		
		SalesOrderDTO salesOrderDTO = this.salesOrderDaoRepository.getSalesOrderById(id);
		
		return salesOrderDTO;
	}

	@Override
	public Page<SalesOrder> getSalesOrderByPage(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, 
				Sort.by("salesOrder").descending());
		
		return this.salesOrderDaoRepository.findAll(pageable);
		
	}

	@Override
	public void update(SalesOrder salesOrder) {
		this.salesOrderDaoRepository.save(salesOrder);
	}

	@Override
	public void delete(long id) {
		this.salesOrderDaoRepository.deleteById(id);
	}

}
