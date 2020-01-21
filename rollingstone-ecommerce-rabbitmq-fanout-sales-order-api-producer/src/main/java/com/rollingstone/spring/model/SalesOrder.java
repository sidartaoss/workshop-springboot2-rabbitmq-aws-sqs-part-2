package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SqlResultSetMapping(name = "SalesOrderMapping", classes = {
		@ConstructorResult(targetClass = SalesOrderDTO.class, columns  = {
				@ColumnResult(name = "id", type = Long.class),
				@ColumnResult(name = "order_number"),
				@ColumnResult(name = "shipping_method"),
				@ColumnResult(name = "estimated_delivery_date", type = Date.class),
				@ColumnResult(name = "special_instruction"),
				@ColumnResult(name = "item_quantity", type = Integer.class),
				@ColumnResult(name = "item_upc_code"),
				@ColumnResult(name = "item_name"),
				@ColumnResult(name = "item_color"),
				@ColumnResult(name = "item_size"),
				@ColumnResult(name = "item_shipped_by"),
				@ColumnResult(name = "house_number"),
				@ColumnResult(name = "street_address"),
				@ColumnResult(name = "city"),
				@ColumnResult(name = "state"),
				@ColumnResult(name = "zip_code"),
				@ColumnResult(name = "acc_id", type = Long.class),
				@ColumnResult(name = "user_id", type = Long.class),
				@ColumnResult(name = "sales_date", type = Date.class),
				@ColumnResult(name = "total_order_amount", type = Double.class),
				@ColumnResult(name = "account_number"),
				@ColumnResult(name = "account_name"),
				@ColumnResult(name = "employee_number"),
				@ColumnResult(name = "emp_id", type = Long.class),
				@ColumnResult(name = "employee_name"),
				@ColumnResult(name = "first_name"),
				@ColumnResult(name = "last_name")
		})
})
@NamedNativeQueries({
	@NamedNativeQuery(name = "SalesOrderDaoRepository.getSalesOrderById",
			query = "SELECT so.id,\n" + 
					"       so.order_number,\n" + 
					"       so.shipping_method,\n" + 
					"       so.estimated_delivery_date,\n" + 
					"       so.special_instruction,\n" + 
					"       sod.item_quantity,\n" + 
					"       itm.item_upc_code,\n" + 
					"       itm.item_name,\n" + 
					"       itm.item_color,\n" + 
					"       itm.item_size,\n" + 
					"       itm.item_shipped_by,\n" + 
					"       addr.house_number,\n" + 
					"       addr.street_address,\n" + 
					"       addr.city,\n" + 
					"       addr.state,\n" + 
					"       addr.zip_code,\n" + 
					"       acc.id acc_id,\n" + 
					"       usr.id user_id,\n" + 
					"       so.sales_date,\n" + 
					"       so.total_order_amount,\n" + 
					"       acc.account_number,\n" + 
					"       acc.account_name,\n" + 
					"       emp.employee_number,\n" + 
					"       emp.id emp_id,\n" + 
					"       emp.employee_name,\n" + 
					"       usr.first_name,\n" + 
					"       usr.last_name\n" + 
					"FROM   rollingstone_sales_order so\n" + 
					"       left outer join rollingstone_account acc on so.account_id = acc.id\n" + 
					"       left outer join rollingstone_address addr on acc.id = addr.account_id\n" + 
					"       left outer join rollingstone_user usr on acc.user_profile_id = usr.id\n" + 
					"       left outer join rollingstone_employee emp on so.employee_id = emp.id\n" + 
					"       left outer join rollingstone_sales_order_details sod on so.id = sod.sales_order_id\n" + 
					"       left outer join rollingstone_item itm on sod.item_id = itm.id \n" + 
					"WHERE  \n" + 
					"       so.id = :id ", resultSetMapping = "SalesOrderMapping" )

})

@Entity
@Table(name = "rollingstone_sales_order")
public class SalesOrder {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "ORDER_NUMBER", nullable = false)
	private String orderNumber;

	@Column(name = "TOTAL_ORDER_AMOUNT", nullable = false)
	private float totalOrderAmount;

	@Column(name = "SPECIAL_INSTRUCTION", nullable = false)
	private String specialInstruction;

	@Temporal(TemporalType.DATE)
	@Column(name = "SALES_DATE", nullable = false, unique = false, length = 10)
	private Date salesDate;

	@Column(name = "SHIPPING_METHOD", nullable = false)
	private String shippingMethod;

	@Temporal(TemporalType.DATE)
	@Column(name = "ESTIMATED_DELIVERY_DATE", nullable = false, unique = false, length = 10)
	private Date estimatedDeliveryDate;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EMPLOYEE_ID")
	private Employee employee;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ACCOUNT_ID")
	private Account account;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "salesOrder")
	private Set<SalesOrderDetails> salesOrderDetails = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public float getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(float totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public String getShippingMethod() {
		return shippingMethod;
	}

	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public Date getEstimatedDeliveryDate() {
		return estimatedDeliveryDate;
	}

	public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
		this.estimatedDeliveryDate = estimatedDeliveryDate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<SalesOrderDetails> getSalesOrderDetails() {
		return salesOrderDetails;
	}

	public void setSalesOrderDetails(Set<SalesOrderDetails> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}

	public SalesOrder(long id, String orderNumber, float totalOrderAmount, String specialInstruction, Date salesDate,
			String shippingMethod, Date estimatedDeliveryDate, Employee employee, Account account,
			Set<SalesOrderDetails> salesOrderDetails) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.totalOrderAmount = totalOrderAmount;
		this.specialInstruction = specialInstruction;
		this.salesDate = salesDate;
		this.shippingMethod = shippingMethod;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.employee = employee;
		this.account = account;
		this.salesOrderDetails = salesOrderDetails;
	}

	public SalesOrder() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((estimatedDeliveryDate == null) ? 0 : estimatedDeliveryDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((salesDate == null) ? 0 : salesDate.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((specialInstruction == null) ? 0 : specialInstruction.hashCode());
		result = prime * result + Float.floatToIntBits(totalOrderAmount);
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
		SalesOrder other = (SalesOrder) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		if (estimatedDeliveryDate == null) {
			if (other.estimatedDeliveryDate != null)
				return false;
		} else if (!estimatedDeliveryDate.equals(other.estimatedDeliveryDate))
			return false;
		if (id != other.id)
			return false;
		if (orderNumber == null) {
			if (other.orderNumber != null)
				return false;
		} else if (!orderNumber.equals(other.orderNumber))
			return false;
		if (salesDate == null) {
			if (other.salesDate != null)
				return false;
		} else if (!salesDate.equals(other.salesDate))
			return false;
		if (shippingMethod == null) {
			if (other.shippingMethod != null)
				return false;
		} else if (!shippingMethod.equals(other.shippingMethod))
			return false;
		if (specialInstruction == null) {
			if (other.specialInstruction != null)
				return false;
		} else if (!specialInstruction.equals(other.specialInstruction))
			return false;
		if (Float.floatToIntBits(totalOrderAmount) != Float.floatToIntBits(other.totalOrderAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SalesOrder [id=" + id + ", orderNumber=" + orderNumber + ", totalOrderAmount=" + totalOrderAmount
				+ ", specialInstruction=" + specialInstruction + ", salesDate=" + salesDate + ", shippingMethod="
				+ shippingMethod + ", estimatedDeliveryDate=" + estimatedDeliveryDate + ", employee=" + employee
				+ ", account=" + account + "]";
	}

}