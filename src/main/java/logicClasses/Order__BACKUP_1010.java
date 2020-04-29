package logicClasses;


import java.util.ArrayList;

import InitClass.Factory;

public class Order_ {
	private ArrayList<OrderLine_> lines;
	private int orderId, custId;
	private double price;

	public Order_(int orderID, int custID) {
		orderId = orderID;
		setCustId(custID);
		lines = new ArrayList<OrderLine_>();
		
	}

	public Order_(int custID) {
		orderId = 0;
		custId = custID;
		lines = new ArrayList<OrderLine_>();
	}

	protected boolean addItem(Item_ item, int AMO) {
		try {
			OrderLine_ singleline = new OrderLine_(orderId, item.getItemId(), AMO);
			lines.add(singleline);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected boolean addOrderLine(OrderLine_ line) {
		try {
			lines.add(line);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	protected ArrayList<OrderLine_> getLines() {
		return lines;
	}

	protected double calcPrice() {
		price = 0.0;
		
		lines.forEach(ele -> {
			ele.setLinePrice();
			price = ele.getLinePrice();
		});

		return price;
	}

	public int getCustId() {
		return custId;
	}

	protected void setCustId(int custId) {
		this.custId = custId;
	}

	public int getOrderId() {
		return orderId;
	}
	public double getPrice() {
		return price;
	}
<<<<<<< Updated upstream
=======
	public String toString() {
		calcPrice();
		String str =  "Order :"+getOrderId()+" Customer :"+getCustId()+" Cost: "+getPrice()+"\n";
			for(int i = 0 ;i < lines.size();  i++) {
				str = str +"\t" +lines.get(i).toString()+"\n";
			}
			return str;
		}	
>>>>>>> Stashed changes
}
