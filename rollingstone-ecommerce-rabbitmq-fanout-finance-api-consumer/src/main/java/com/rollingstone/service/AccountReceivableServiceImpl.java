package com.rollingstone.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.rollingstone.dao.AccountReceivableDaoRepository;
import com.rollingstone.model.AccountReceivable;

@Service
public class AccountReceivableServiceImpl implements AccountReceivableService {

	private static final Logger LOG = LoggerFactory.getLogger(AccountReceivableServiceImpl.class);

	private AccountReceivableDaoRepository accountReceivableDaoRepository;
	
	public AccountReceivableServiceImpl(AccountReceivableDaoRepository accountReceivableDaoRepository) {
		this.accountReceivableDaoRepository = accountReceivableDaoRepository;
	}
	
	@Override
	public AccountReceivable save(AccountReceivable accountReceivable) {
		LOG.info("This is the save method of AccountReceivableServiceImpl");
		LOG.info("Account Model Received from Sales Order Producer: " + accountReceivable.toString());
		return this.accountReceivableDaoRepository.save(accountReceivable);
	}

	@Override
	public AccountReceivable getAccountReceivable(Long id) {
		AccountReceivable accountReceivable = this.accountReceivableDaoRepository.getAccountReceivableById(id);
		return accountReceivable;
	}

	@Override
	public Page<AccountReceivable> getAccountReceivableByPage(Integer pageNumber, Integer pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("accountNumber").descending());
		return this.accountReceivableDaoRepository.findAll(pageable);
	}

	@Override
	public void update(AccountReceivable accountReceivable) {
		this.accountReceivableDaoRepository.save(accountReceivable);
	}

	@Override
	public void delete(Long id) {
		this.accountReceivableDaoRepository.deleteById(id);
	}

}
