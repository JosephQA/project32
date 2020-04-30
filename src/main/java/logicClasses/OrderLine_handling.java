package logicClasses;

import java.util.ArrayList;

import InitClass.Factory;
import enums.OrderLineFields;

public class OrderLine_handling {
	Database_handling dbh;
Factory f = Factory.getFactory();
	public OrderLine_handling(String str) {
		dbh = f.getDatabaseHandling(str);
	}
	public OrderLine_handling() {
		dbh = f.getDatabaseHandling();
	}

	public double getLinePrice(OrderLine_ line) {
//		System.out.println("++TEST++"+line.getItemAmo()+":"+line.getItemId());
//		System.out.println("++TEST++"+ dbh.getLinePrice(line.getItemId()));
		return dbh.getLinePrice(line.getItemId())*line.getItemAmo();
	}
	public OrderLine_ getPricedLine(OrderLine_ line) {
		line.setLinePrice();
		return line;
	}

	public OrderLine_ createLine(int orderID, int itemID, int itemAMO) {
		int lineID;
		lineID = dbh.createLine(orderID, itemID, itemAMO);
		if (lineID == -1) {
			return null;
		}
		if (lineID == -2) {
			System.out.println("unknown error updateOrderAddLine");
		}
		OrderLine_ ordlin = new OrderLine_(orderID, lineID, itemID, itemAMO);
		return ordlin;
	}

	public OrderLine_ createLine(OrderLine_ line) {
		return createLine(line.getOrderId(), line.getItemId(), line.getItemAmo());
	}

	public ArrayList<OrderLine_> getLinesbyOrder(int ordID) {
		return dbh.getLinesOrder(ordID);
	}

	public OrderLine_ getOrderLine(int ordID, int lineID) {
		return dbh.getOrderLine(ordID, lineID);
	}

	public boolean updateLine(int orderID, int lineID, OrderLineFields fld, int itemvar) {

		return dbh.updateOrderLine(orderID, lineID, fld, itemvar);
	}

	public boolean deleteLine(int orderID, int lineID) {

		return dbh.deleteLine(orderID, lineID);

	}

}
