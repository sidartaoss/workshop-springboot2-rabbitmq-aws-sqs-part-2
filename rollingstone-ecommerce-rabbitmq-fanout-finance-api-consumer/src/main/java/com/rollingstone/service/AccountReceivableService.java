package com.rollingstone.service;

import org.springframework.data.domain.Page;

import com.rollingstone.model.AccountReceivable;

public interface AccountReceivableService {

	AccountReceivable save(AccountReceivable accountReceivable);
	
	AccountReceivable getAccountReceivable(Long id);
	
	Page<AccountReceivable> getAccountReceivableByPage(Integer pageNumber, Integer pageSize);
	
	void update(AccountReceivable accountReceivable);
	
	void delete(Long id);
}
