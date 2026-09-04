package assign1;

public class Driver {
	public static void main(String[] args) {
		OrderDB db = new OrderDB();
		db.loadOrders("orders.txt");
		//db.showOrders();
		db.saveOrders("orders2.txt");
		
		Order order = new Order(2001, "Jim Brennan", "Mechanical Keyboard", 95.99, "9-3-2025");
		db.add(order);
		//db.showOrders();
		
		db.add(7, order);
		//System.out.println(db.get(7));
		System.out.println(db.searchByOrderID(1007));
		
		db.remove(7);
		//db.showOrders();
		
		db.set(0, order);
		System.out.println(db.get(0));
		System.out.println(db.size());
		System.out.println(db.capacity());
	}
}
