package assign1;

public class Order {
	private int orderID;
	private String customerName;
	private String productType;
	private double totalAmount;
	private String orderDate;
	
	public Order()	{
		
	}
	
	public Order(int orderID, String customerName, String productType, double totalAmount, String orderDate) {
		this.orderID = orderID;
		this.customerName = customerName;
		this.productType = productType;
		this.totalAmount = totalAmount;
		this.orderDate = orderDate;
	}

	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String toString() {
		return String.format("%-9d%-30s%11.2f", this.orderID, this.productType, this.totalAmount);
	}
}
