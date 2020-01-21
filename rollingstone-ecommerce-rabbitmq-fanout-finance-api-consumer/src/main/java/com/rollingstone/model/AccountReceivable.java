package com.rollingstone.model;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ROLLINGSTONE_ACCOUNT_RECEIVABLE")
public class AccountReceivable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TRANSACTION_NUMBER", nullable = false)
	private String transactionNumber;
	
	@Column(name = "ACCOUNT_ID", nullable = false)
	private Long accountId;
	
	@Column(name = "USER_ID", nullable = false)
	private Long userId;
	
	@Column(name = "SALES_ORDER_ID", nullable = false)
	private Long salesOrderId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "TRANSACTION_DATE", nullable = false, length = 10)
	private Date transactionDate;
	
	@Column(name = "TRANSACTION_AMOUNT", nullable = false)
	private BigDecimal transactionAmount;
	
	@Column(name = "SALES_REP_ID", nullable = false)
	private Long salesRepId;
	
	public AccountReceivable() {
	}

	public AccountReceivable(String transactionNumber, Long accountId, Long userId, Long salesOrderId,
			Date transactionDate, BigDecimal transactionAmount, Long salesRepId) {
		super();
		this.transactionNumber = transactionNumber;
		this.accountId = accountId;
		this.userId = userId;
		this.salesOrderId = salesOrderId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.salesRepId = salesRepId;
	}

	public AccountReceivable(Long id, String transactionNumber, Long accountId, Long userId, Long salesOrderId,
			Date transactionDate, BigDecimal transactionAmount, Long salesRepId) {
		super();
		this.id = id;
		this.transactionNumber = transactionNumber;
		this.accountId = accountId;
		this.userId = userId;
		this.salesOrderId = salesOrderId;
		this.transactionDate = transactionDate;
		this.transactionAmount = transactionAmount;
		this.salesRepId = salesRepId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(String transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(Long salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public Date getTransactionDate() {
		return transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

	public BigDecimal getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(BigDecimal transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public Long getSalesRepId() {
		return salesRepId;
	}

	public void setSalesRepId(Long salesRepId) {
		this.salesRepId = salesRepId;
	}

	@Override
	public String toString() {
		return "AccountReceivable [id=" + id + ", transactionNumber=" + transactionNumber + ", accountId=" + accountId
				+ ", userId=" + userId + ", salesOrderId=" + salesOrderId + ", transactionDate=" + transactionDate
				+ ", transactionAmount=" + transactionAmount + ", salesRepId=" + salesRepId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((salesOrderId == null) ? 0 : salesOrderId.hashCode());
		result = prime * result + ((salesRepId == null) ? 0 : salesRepId.hashCode());
		result = prime * result + ((transactionAmount == null) ? 0 : transactionAmount.hashCode());
		result = prime * result + ((transactionDate == null) ? 0 : transactionDate.hashCode());
		result = prime * result + ((transactionNumber == null) ? 0 : transactionNumber.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AccountReceivable other = (AccountReceivable) obj;
		if (accountId == null) {
			if (other.accountId != null)
				return false;
		} else if (!accountId.equals(other.accountId))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (salesOrderId == null) {
			if (other.salesOrderId != null)
				return false;
		} else if (!salesOrderId.equals(other.salesOrderId))
			return false;
		if (salesRepId == null) {
			if (other.salesRepId != null)
				return false;
		} else if (!salesRepId.equals(other.salesRepId))
			return false;
		if (transactionAmount == null) {
			if (other.transactionAmount != null)
				return false;
		} else if (!transactionAmount.equals(other.transactionAmount))
			return false;
		if (transactionDate == null) {
			if (other.transactionDate != null)
				return false;
		} else if (!transactionDate.equals(other.transactionDate))
			return false;
		if (transactionNumber == null) {
			if (other.transactionNumber != null)
				return false;
		} else if (!transactionNumber.equals(other.transactionNumber))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		return true;
	}

}









