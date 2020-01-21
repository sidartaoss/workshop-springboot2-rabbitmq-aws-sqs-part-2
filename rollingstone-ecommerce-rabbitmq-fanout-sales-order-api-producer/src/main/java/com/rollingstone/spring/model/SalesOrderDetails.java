package com.rollingstone.spring.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ROLLINGSTONE_SALES_ORDER_DETAILS")
public class SalesOrderDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "ITEM_LINE_NO", nullable = false)
	private String itemLineNumber;
	
	@Column(name = "UNIT_PRICE", nullable = false)
	private BigDecimal unitPrice;
	
	@Column(name = "ITEM_QUANTITY", nullable = false)
	private Integer itemQuantity;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SALES_ORDER_ID", nullable = false)
	private SalesOrder salesOrder;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ITEM_ID", nullable = false)
	private ItemMaster item;

	public SalesOrderDetails() {
		super();
	}

	public SalesOrderDetails(Long id, String itemLineNumber, BigDecimal unitPrice, Integer itemQuantity,
			SalesOrder salesOrder, ItemMaster item) {
		super();
		this.id = id;
		this.itemLineNumber = itemLineNumber;
		this.unitPrice = unitPrice;
		this.itemQuantity = itemQuantity;
		this.salesOrder = salesOrder;
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemLineNumber() {
		return itemLineNumber;
	}

	public void setItemLineNumber(String itemLineNumber) {
		this.itemLineNumber = itemLineNumber;
	}

	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	public Integer getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(Integer itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public SalesOrder getSalesOrder() {
		return salesOrder;
	}

	public void setSalesOrder(SalesOrder salesOrder) {
		this.salesOrder = salesOrder;
	}

	public ItemMaster getItem() {
		return item;
	}

	public void setItem(ItemMaster item) {
		this.item = item;
	}

	@Override
	public String toString() {
		return "SalesOrderDetails [id=" + id + ", itemLineNumber=" + itemLineNumber + ", unitPrice=" + unitPrice
				+ ", itemQuantity=" + itemQuantity + ", salesOrder=" + salesOrder + ", item=" + item + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + ((itemLineNumber == null) ? 0 : itemLineNumber.hashCode());
		result = prime * result + ((itemQuantity == null) ? 0 : itemQuantity.hashCode());
		result = prime * result + ((salesOrder == null) ? 0 : salesOrder.hashCode());
		result = prime * result + ((unitPrice == null) ? 0 : unitPrice.hashCode());
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
		SalesOrderDetails other = (SalesOrderDetails) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemLineNumber == null) {
			if (other.itemLineNumber != null)
				return false;
		} else if (!itemLineNumber.equals(other.itemLineNumber))
			return false;
		if (itemQuantity == null) {
			if (other.itemQuantity != null)
				return false;
		} else if (!itemQuantity.equals(other.itemQuantity))
			return false;
		if (salesOrder == null) {
			if (other.salesOrder != null)
				return false;
		} else if (!salesOrder.equals(other.salesOrder))
			return false;
		if (unitPrice == null) {
			if (other.unitPrice != null)
				return false;
		} else if (!unitPrice.equals(other.unitPrice))
			return false;
		return true;
	}

}
