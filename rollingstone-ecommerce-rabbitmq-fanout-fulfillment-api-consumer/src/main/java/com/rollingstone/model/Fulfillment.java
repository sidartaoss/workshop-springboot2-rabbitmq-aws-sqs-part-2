package com.rollingstone.model;

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
@Table(name = "ROLLINGSTONE_FULFILLMENT")
public class Fulfillment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "FULFILLMENT_NUMBER", nullable = false)
	private String fulfillmentNumber;	
	
	@Column(name = "ORDER_NUMBER", nullable = false)
	private String orderNumber;

	@Column(name = "SPECIAL_INSTRUCTION", nullable = false)
	private String shippingMethod;

	@Column(name = "SHIPPING_METHOD", nullable = false)
	private String shippingNumber;

	@Temporal(TemporalType.DATE)
	@Column(name = "ESTIMATED_DELIVERY_DATE", nullable = false, length = 10)
	private Date estimatedDeliveryDate;
	
	@Column(name = "ITEM_UPC_CODE", nullable = false)
	private String itemUpcCode;
	
	@Column(name = "ITEM_NAME", nullable = false)
	private String itemName;
	
	@Column(name = "ITEM_QUANTITY", nullable = false)
	private String itemQuantity;
	
	private String size;
	
	private String color;
	
	@Column(name = "SHIPPED_BY", nullable = false)
	private String shippedBy;
	
	@Column(name = "SHIPPING_ADDRESS", nullable = false)
	private String shippingAddress;

	public Fulfillment() {
		super();
	}

	public Fulfillment(long id, String fulfillmentNumber, String orderNumber, String shippingMethod,
			String shippingNumber, Date estimatedDeliveryDate, String itemUpcCode, String itemName, String itemQuantity,
			String size, String color, String shippedBy, String shippingAddress) {
		super();
		this.id = id;
		this.fulfillmentNumber = fulfillmentNumber;
		this.orderNumber = orderNumber;
		this.shippingMethod = shippingMethod;
		this.shippingNumber = shippingNumber;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.itemUpcCode = itemUpcCode;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.size = size;
		this.color = color;
		this.shippedBy = shippedBy;
		this.shippingAddress = shippingAddress;
	}
	
	public Fulfillment(String fulfillmentNumber, String orderNumber, String shippingMethod,
			String shippingNumber, Date estimatedDeliveryDate, String itemUpcCode, String itemName, String itemQuantity,
			String size, String color, String shippedBy, String shippingAddress) {
		super();
		this.fulfillmentNumber = fulfillmentNumber;
		this.orderNumber = orderNumber;
		this.shippingMethod = shippingMethod;
		this.shippingNumber = shippingNumber;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.itemUpcCode = itemUpcCode;
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.size = size;
		this.color = color;
		this.shippedBy = shippedBy;
		this.shippingAddress = shippingAddress;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFulfillmentNumber() {
		return fulfillmentNumber;
	}

	public void setFulfillmentNumber(String fulfillmentNumber) {
		this.fulfillmentNumber = fulfillmentNumber;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getShippingNumber() {
		return shippingNumber;
	}

	public void setShippingNumber(String shippingNumber) {
		this.shippingNumber = shippingNumber;
	}

	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public String getItemUpcCode() {
		return itemUpcCode;
	}

	public void setItemUpcCode(String itemUpcCode) {
		this.itemUpcCode = itemUpcCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(String itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getShippedBy() {
		return shippedBy;
	}

	public void setShippedBy(String shippedBy) {
		this.shippedBy = shippedBy;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public String toString() {
		return "Fulfillment [id=" + id + ", fulfillmentNumber=" + fulfillmentNumber + ", orderNumber=" + orderNumber
				+ ", shippingMethod=" + shippingMethod + ", shippingNumber=" + shippingNumber
				+ ", estimatedDeliveryDate=" + estimatedDeliveryDate + ", itemUpcCode=" + itemUpcCode + ", itemName="
				+ itemName + ", itemQuantity=" + itemQuantity + ", size=" + size + ", color=" + color + ", shippedBy="
				+ shippedBy + ", shippingAddress=" + shippingAddress + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((estimatedDeliveryDate == null) ? 0 : estimatedDeliveryDate.hashCode());
		result = prime * result + ((fulfillmentNumber == null) ? 0 : fulfillmentNumber.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemQuantity == null) ? 0 : itemQuantity.hashCode());
		result = prime * result + ((itemUpcCode == null) ? 0 : itemUpcCode.hashCode());
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((shippedBy == null) ? 0 : shippedBy.hashCode());
		result = prime * result + ((shippingAddress == null) ? 0 : shippingAddress.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((shippingNumber == null) ? 0 : shippingNumber.hashCode());
		result = prime * result + ((size == null) ? 0 : size.hashCode());
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
		Fulfillment other = (Fulfillment) obj;
		if (color == null) {
			if (other.color != null)
				return false;
		} else if (!color.equals(other.color))
			return false;
		if (estimatedDeliveryDate == null) {
			if (other.estimatedDeliveryDate != null)
				return false;
		} else if (!estimatedDeliveryDate.equals(other.estimatedDeliveryDate))
			return false;
		if (fulfillmentNumber == null) {
			if (other.fulfillmentNumber != null)
				return false;
		} else if (!fulfillmentNumber.equals(other.fulfillmentNumber))
			return false;
		if (id != other.id)
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		if (itemQuantity == null) {
			if (other.itemQuantity != null)
				return false;
		} else if (!itemQuantity.equals(other.itemQuantity))
			return false;
		if (itemUpcCode == null) {
			if (other.itemUpcCode != null)
				return false;
		} else if (!itemUpcCode.equals(other.itemUpcCode))
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (shippedBy == null) {
			if (other.shippedBy != null)
				return false;
		} else if (!shippedBy.equals(other.shippedBy))
			return false;
		if (shippingAddress == null) {
			if (other.shippingAddress != null)
				return false;
		} else if (!shippingAddress.equals(other.shippingAddress))
			return false;
		if (shippingMethod == null) {
			if (other.shippingMethod != null)
				return false;
		} else if (!shippingMethod.equals(other.shippingMethod))
			return false;
		if (shippingNumber == null) {
			if (other.shippingNumber != null)
				return false;
		} else if (!shippingNumber.equals(other.shippingNumber))
			return false;
		if (size == null) {
			if (other.size != null)
				return false;
		} else if (!size.equals(other.size))
			return false;
		return true;
	}

}












