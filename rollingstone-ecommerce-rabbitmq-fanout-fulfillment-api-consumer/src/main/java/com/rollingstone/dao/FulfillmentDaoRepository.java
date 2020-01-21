package com.rollingstone.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.model.Fulfillment;

public interface FulfillmentDaoRepository extends PagingAndSortingRepository<Fulfillment, Long> {

	Page<Fulfillment> findAll(Pageable pageable);

	@Query(name = "FulfillmentDaoRepository.getFulfillmentById", nativeQuery = true)
	Fulfillment getFulfillmentById(@Param("id") Long id);

}
