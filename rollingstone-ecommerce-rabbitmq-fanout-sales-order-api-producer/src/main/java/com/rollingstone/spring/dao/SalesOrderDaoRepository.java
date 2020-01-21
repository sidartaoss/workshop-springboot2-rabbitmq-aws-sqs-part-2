package com.rollingstone.spring.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.spring.model.SalesOrder;
import com.rollingstone.spring.model.SalesOrderDTO;

public interface SalesOrderDaoRepository extends PagingAndSortingRepository<SalesOrder, Long> {

	Page<SalesOrder> findAll(Pageable pageable);
	
	@Query(name = "SalesOrderDaoRepository.getSalesOrderById", nativeQuery = true)
	SalesOrderDTO getSalesOrderById(@Param("id") long id);
}
