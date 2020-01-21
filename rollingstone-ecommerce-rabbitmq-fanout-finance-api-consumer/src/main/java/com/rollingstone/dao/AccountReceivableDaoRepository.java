package com.rollingstone.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.rollingstone.model.AccountReceivable;

public interface AccountReceivableDaoRepository extends PagingAndSortingRepository<AccountReceivable, Long> {

	Page<AccountReceivable> findAll(Pageable pageable);
	
	@Query(name = "AccountReceivableDaoRepository.getAccountReceivableById", nativeQuery = true)
	AccountReceivable getAccountReceivableById(@Param("id") Long id);
	
	
}
