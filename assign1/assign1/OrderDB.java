package assign1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

public class OrderDB implements OrderDBInterface{
	Order[] orders = new Order[25];
	
	@Override
	public int loadOrders(String fileName) {
		int index = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line;
			while((line = br.readLine()) != null && (index - 1< orders.length)) {
				if(index > 0) {
					String[] data = line.split(",");
					
					int orderID = Integer.parseInt(data[0]);
					String customerName = data[1];
					String productType = data[2];
					double totalAmount = Double.parseDouble(data[3]);
					String orderDate = data[4];
					
					Order o = new Order(orderID, customerName, productType, totalAmount, orderDate);
					orders[index - 1] = o;
				}
				index++;
			}
			br.close();
		}catch(FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}catch(Exception e) {
			System.out.println("ERROR: " + e.toString());
		}
		return index - 1;
	}

	@Override
	public int saveOrders(String fileName) {
		int records = 0;
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));
			bw.write("Order_ID,Customer_Name,Product,Total_Amount,Order_Date");
			bw.newLine();
			for(int i = 0; i < orders.length; i++) {
				bw.write(orders[i].getOrderID() + "," + orders[i].getCustomerName() + "," + orders[i].getProductType() + "," + orders[i].getTotalAmount() + "," + orders[i].getOrderDate());
				bw.newLine();
				records++;
			}
			bw.close();
		}catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found.");
		}catch(Exception e) {
			System.out.println("ERROR: " + e.toString());
		}
		
		return records;
	}

	@Override
	public void showOrders() {
		System.out.println("Order ID Product                         Total Amt");
		System.out.println("-------- -------                         ---------");
		for(int i = 0; i < orders.length; i++) {
			System.out.println(orders[i].toString());
		}
	}

	@Override
	public boolean add(Order order) {
		if(orders[orders.length - 1] == null) {
			orders[orders.length - 1] = order;
			return true;
		}
		return false;
	}

	@Override
	public void add(int index, Order order) {
		//Inserts the order at the specified position in this array.
		orders[index] = order;
		
	}

	@Override
	public void clear() {
		for(int i = 0; i < orders.length; i++) {
			orders[i] = null;
		}
		
	}

	@Override
	public Order get(int index) {
		return orders[index];
	}

	@Override
	public int searchByOrderID(int orderID) {
		for(int i = 0; i < orders.length; i++) {
			if(orders[i].getOrderID() == orderID) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public Order remove(int index) {
		Order order = new Order();
		order = orders[index];
		orders[index] = null;
		return order;
	}

	@Override
	public Order set(int index, Order order) {
		Order oldOrder = new Order();
		oldOrder = orders[index];
		orders[index] = order;
		return oldOrder;
	}

	@Override
	public int size() {
		int size = 0;
		for(int i = 0; i < orders.length; i++) {
			if(orders[i] != null) {
				size++;
			}
		}
		return size;
	}

	@Override
	public int capacity() {
		return orders.length;
	}

	@Override
	public void resize() {
		Order[] newOrders = new Order[orders.length + 25];
		for(int i = 0; i < newOrders.length; i++) {
			if(i < orders.length) {
				newOrders[i] = orders[i];
			}else {
				newOrders[i] = null;
			}
		}
		Order[] orders = new Order[newOrders.length];
		for(int j = 0; j < orders.length; j++) {
			orders[j] = newOrders[j];
		}
	}

}
