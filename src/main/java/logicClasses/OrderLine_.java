package logicClasses;
import InitClass.Factory;

public class OrderLine_ {
	private int orderId;
	private int lineNo;
	private int itemId;
	private int itemAmo;
	private double linePrice;
	private String tst = "";

	public OrderLine_(int orderID, int itemID, int itemAMO) {
		orderId = orderID;
		itemId = itemID;
		itemAmo = itemAMO;
		// setLinePrice(); cannot call in a resultSET LOOP
	}

	public OrderLine_(int orderID, int orderline, int itemID, int itemAMO) {
		orderId = orderID;
		lineNo = orderline;
		itemId = itemID;
		itemAmo = itemAMO;
		// setLinePrice();
	}

	public OrderLine_(int orderID, int orderline, int itemID, int itemAMO, String tsts) {
		orderId = orderID;
		lineNo = orderline;
		itemId = itemID;
		itemAmo = itemAMO;
		tst = tsts;
	}

	public int getOrderId() {
		return orderId;
	}

	protected void setOrderId(int orderID) {
		orderId = orderID;
	}

	public int getItemId() {
		return itemId;
	}

	protected void setItemId(int itemID) {
		itemId = itemID;
	}

	public int getItemAmo() {
		return itemAmo;
	}

	protected void setItemAmo(int itemAMO) {
		itemAmo = itemAMO;
	}

	public double getLinePrice() {
		return linePrice;
	}

	protected void setLinePrice() {
		OrderLine_handling handler = Factory.getOrderlinehandler();
		linePrice = handler.getLinePrice(this);
	}

	public int getLineNo() {
		return lineNo;
	}
	@Override
	public String toString() {
		String str = "Order: "+this.getOrderId()+
					" Line: "+this.getLineNo() +" Item: "+this.getItemId()+
					" Amount: "+this.getItemAmo();
		return str;
					}
}
