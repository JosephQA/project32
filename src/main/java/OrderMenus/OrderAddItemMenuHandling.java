package OrderMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.OrderLine_handling;
import logicClasses.Order_;
import logicClasses.Order_Handling;

public class OrderAddItemMenuHandling {
	Scanner scan;
	OrderAddItemMenu upmenu;
Factory f = new Factory();
	OrderAddItemMenuHandling(Scanner scanIn, OrderAddItemMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}

	protected void handleDisplayMenu(int intput) {
		switch(intput) {
		case 1: 
			upmenu.startAddingItem();
			break;
		case 0: upmenu.upmenu.displayMenu();
			break;
		default: 
			System.out.println("enter valid number of option \"1\" or \"0\"");
			upmenu.displayMenu();
			break;
		}
	}
	protected Order_  orderInit(int intput) {
		Order_ ordo = f.getOrderHandler().getOrderbyId(intput);
		return ordo;
	}
	protected boolean addItemtoOrder(Order_ orderobj, int ItemId, int ItemAmo) {
		OrderLine_handling linehan = f.getOrderlinehandler();
//		return true if line return is not null (line created)
		return ( linehan.createLine(orderobj.getOrderId(), ItemId, ItemAmo) != null);
	}
	
}
