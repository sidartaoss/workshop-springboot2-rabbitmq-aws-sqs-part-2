package com.rollingstone.spring.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class SalesOrderDTO {

	private long id;
	private String orderNumber;
	private double totalOrderAmount;
	private String specialInstruction;
	private String shippingMethod;
	private Date estimatedDeliveryDate;
	private int itemQuantity;
	private Employee employee;
	private Date salesDate;
	private Account account;
	private Address address;
	private User user;
	private ItemMaster item;
	private Set<SalesOrderDetails> salesOrderDetails = new HashSet<>();
	
	private String itemUPCCode;
	private String itemName;
	private String itemColor;
	private String itemSize;
	private String shippedBy;
	private String houseNumber;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private Long accountId;
	private Long userId;
	private String accountNumber;
	private String accountName;
	private String employeeNumber;
	private Long employeeId;
	private String employeeName;
	private String firstName;
	private String lastName;

	public SalesOrderDTO() {
		super();
	}

	public SalesOrderDTO(long id, String orderNumber, double totalOrderAmount, String specialInstruction,
			String shippingMethod, Date estimatedDeliveryDate, int itemQuantity, Employee employee, Date salesDate,
			Account account, Address address, User user, ItemMaster item, Set<SalesOrderDetails> salesOrderDetails) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.totalOrderAmount = totalOrderAmount;
		this.specialInstruction = specialInstruction;
		this.shippingMethod = shippingMethod;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.itemQuantity = itemQuantity;
		this.employee = employee;
		this.salesDate = salesDate;
		this.account = account;
		this.address = address;
		this.user = user;
		this.item = item;
		this.salesOrderDetails = salesOrderDetails;
	}
	
	public SalesOrderDTO(long id, String orderNumber, String shippingMethod, Date estimatedDeliveryDate,
				String specialInstruction, int itemQuantity, String itemUPCCode, String itemName, String itemColor,
				String itemSize, String shippedBy, String houseNumber, String streetAddress, String city, String state,
				String zipCode, Long accountId, Long userId, Date salesDate, Double totalOrderAmount, String accountNumber,
				String accountName, String employeeNumber, Long employeeId, String employeeName, String firstName, String lastName
			) {
		this.id = id;
		this.orderNumber = orderNumber;
		this.shippingMethod = shippingMethod;
		this.estimatedDeliveryDate = estimatedDeliveryDate;
		this.specialInstruction = specialInstruction;
		/** ### Item ### **/
		this.item = new ItemMaster();
		this.itemQuantity = itemQuantity;
		this.itemUPCCode = itemUPCCode;
		this.item.setItemUPCCode(this.itemUPCCode);
		this.itemName = itemName;
		this.item.setItemName(this.itemName);
		this.itemColor = itemColor;
		this.item.setItemColor(this.itemColor);
		this.itemSize = itemSize;
		this.item.setItemSize(this.itemSize);
		this.shippedBy = shippedBy;
		this.item.setShippedBy(this.shippedBy);
		/** ### Address ### **/
		this.address = new Address();
		this.houseNumber = houseNumber;
		this.address.setHouseNumber(this.houseNumber);
		this.streetAddress = streetAddress;
		this.address.setStreetAddress(this.streetAddress);
		this.city = city;
		this.address.setCity(this.city);
		this.state = state;
		this.address.setState(this.state);
		this.zipCode = zipCode;
		this.address.setZipCode(this.zipCode);
		/** ### Account ### **/
		this.accountId = accountId;
		this.account = new Account();
		this.account.setId(this.accountId);
		/** ### User ### **/
		this.userId = userId;
		this.account.setUser(new User());
		this.account.getUser().setId(this.userId);
		this.salesDate = salesDate;
		this.totalOrderAmount = totalOrderAmount;
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.employeeNumber = employeeNumber;
		/** ### Employee ### **/
		this.employeeId = employeeId;
		this.employee = new Employee();
		this.employee.setId(this.employeeId);
		this.employeeName = employeeName;
		/** ### User ### **/
		this.firstName = firstName;
		this.account.getUser().setFirstName(this.firstName);
		this.lastName = lastName;
		this.account.getUser().setLastName(this.lastName);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumbeEr(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getTotalOrderAmount() {
		return totalOrderAmount;
	}

	public void setTotalOrderAmount(double totalOrderAmount) {
		this.totalOrderAmount = totalOrderAmount;
	}

	public String getSpecialInstruction() {
		return specialInstruction;
	}

	public void setSpecialInstruction(String specialInstruction) {
		this.specialInstruction = specialInstruction;
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

	public int getItemQuantity() {
		return itemQuantity;
	}

	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public ItemMaster getItem() {
		return item;
	}

	public void setItem(ItemMaster item) {
		this.item = item;
	}

	public Set<SalesOrderDetails> getSalesOrderDetails() {
		return salesOrderDetails;
	}

	public void setSalesOrderDetails(Set<SalesOrderDetails> salesOrderDetails) {
		this.salesOrderDetails = salesOrderDetails;
	}
	
	public String getItemUPCCode() {
		return itemUPCCode;
	}

	public void setItemUPCCode(String itemUPCCode) {
		this.itemUPCCode = itemUPCCode;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemColor() {
		return itemColor;
	}

	public void setItemColor(String itemColor) {
		this.itemColor = itemColor;
	}

	public String getItemSize() {
		return itemSize;
	}

	public void setItemSize(String itemSize) {
		this.itemSize = itemSize;
	}

	public String getShippedBy() {
		return shippedBy;
	}

	public void setShippedBy(String shippedBy) {
		this.shippedBy = shippedBy;
	}

	public String getHouseNumber() {
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber) {
		this.houseNumber = houseNumber;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getEmployeeNumber() {
		return employeeNumber;
	}

	public void setEmployeeNumber(String employeeNumber) {
		this.employeeNumber = employeeNumber;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "SalesOrderDTO [id=" + id + ", orderNumber=" + orderNumber + ", totalOrderAmount=" + totalOrderAmount
				+ ", specialInstruction=" + specialInstruction + ", shippingMethod=" + shippingMethod
				+ ", estimatedDeliveryDate=" + estimatedDeliveryDate + ", itemQuantity=" + itemQuantity + ", employee="
				+ employee + ", salesDate=" + salesDate + ", account=" + account + ", address=" + address + ", user="
				+ user + ", item=" + item + ", salesOrderDetails=" + salesOrderDetails + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		result = prime * result + ((estimatedDeliveryDate == null) ? 0 : estimatedDeliveryDate.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		result = prime * result + itemQuantity;
		result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
		result = prime * result + ((salesDate == null) ? 0 : salesDate.hashCode());
		result = prime * result + ((salesOrderDetails == null) ? 0 : salesOrderDetails.hashCode());
		result = prime * result + ((shippingMethod == null) ? 0 : shippingMethod.hashCode());
		result = prime * result + ((specialInstruction == null) ? 0 : specialInstruction.hashCode());
		long temp;
		temp = Double.doubleToLongBits(totalOrderAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		SalesOrderDTO other = (SalesOrderDTO) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
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
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		if (itemQuantity != other.itemQuantity)
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
		if (salesOrderDetails == null) {
			if (other.salesOrderDetails != null)
				return false;
		} else if (!salesOrderDetails.equals(other.salesOrderDetails))
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
		if (Double.doubleToLongBits(totalOrderAmount) != Double.doubleToLongBits(other.totalOrderAmount))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
