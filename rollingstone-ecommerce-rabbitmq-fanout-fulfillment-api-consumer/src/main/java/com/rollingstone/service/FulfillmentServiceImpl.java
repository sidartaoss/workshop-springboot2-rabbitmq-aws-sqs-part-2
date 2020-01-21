package com.rollingstone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.FulfillmentDaoRepository;
import com.rollingstone.model.Fulfillment;

@Service
public class FulfillmentServiceImpl implements FulfillmentService {

	private static final Logger LOG = LoggerFactory.getLogger(FulfillmentServiceImpl.class);

	private FulfillmentDaoRepository fulfillmentDaoRepository;
	
	public FulfillmentServiceImpl(FulfillmentDaoRepository fulfillmentDaoRepository) {
		this.fulfillmentDaoRepository = fulfillmentDaoRepository;
	}
	
	@Override
	public Fulfillment save(Fulfillment fulfillment) {
		LOG.info("This is the save method of FulfillmentServiceImpl");
		LOG.info("Fulfillment Model Received from Sales Order Producer: " + fulfillment.toString());
		return this.fulfillmentDaoRepository.save(fulfillment);
	}

	@Override
	public Fulfillment getFulfillment(Long id) {
		Fulfillment fulfillment = this.fulfillmentDaoRepository.getFulfillmentById(id);
		return fulfillment;
	}

	@Override
	public Page<Fulfillment> getFulfillmentByPage(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("fulfillmentNumber").descending());
		return this.fulfillmentDaoRepository.findAll(pageable);
	}

	@Override
	public void update(Fulfillment fulfillment) {
		this.fulfillmentDaoRepository.save(fulfillment);
	}

	@Override
	public void delete(Long id) {
		this.fulfillmentDaoRepository.deleteById(id);
	}

}
