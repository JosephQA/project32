package OrderMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Item_;
import logicClasses.Item_Handling;
import logicClasses.OrderLine_;
import logicClasses.OrderLine_handling;
import logicClasses.Order_;
import logicClasses.Order_Handling;

public class OrderCreationMenuHandling {
	Scanner scan;
	OrderCreationMenu upmenu;
	Order_ orderInProgress;
	Order_Handling ordh;
	OrderLine_handling linh;
Factory f = new Factory();
	public OrderCreationMenuHandling(Scanner scanIn, OrderCreationMenu obj) {
		scan = scanIn;
		upmenu = obj;
		ordh = f.getOrderHandler();
		linh = f.getOrderlinehandler();
	}

	void handleMenuInput(int intput) {
		switch (intput) {
		case 1:
			upmenu.beginCreation();
			break;
		case 0:
			upmenu.upmenu.displayMenu();
			break;
		default:
			System.out.println("input not recognised \n enter \"1\" or \"0\" ");
			break;
		}
	}

	Order_ processcustIdIn(int custid) {
		orderInProgress = ordh.createOrderInDB(custid);
		return orderInProgress;
	}

	boolean checkItem(int itemID, int itemAmo) {
		String msg = "";
		boolean bool = false;
		// DB.check item exist // true -> msg+="item exists!!"(check amo) //fasle ->
		// msg+="item does not exist"
		// DB.check item amo > itemAmo // true -> msg+="item amount allowed(bool = true)
		// // false msg+="only "+DB.getITemAmo(itemID)+" exist"
		// syso(msg)
		//
		Item_ item = fetchitem(itemID);
		if (item.getItemAmo() > itemAmo) {
			bool = true; //

		} else {
			bool = false;

		}
		return bool;

	}
	protected Item_ fetchitem(int itemID) {
		Item_Handling itemhan = f.getItemHandler();
		Item_ item = itemhan.getItembyID(itemID);
		return item;
	}

	public String addItem(Order_ orderHead, int itemID, int itemAmo) {
		// TODO Auto-generated method stub
		OrderLine_ lin = linh.createLine(orderHead.getOrderId(), itemID, itemAmo);
		if (lin != null) {
			return lin.toString();
		} else {
			return "addtion failure";
		}
	}
}
