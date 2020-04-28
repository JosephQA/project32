package OrderMenus;

import java.util.Scanner;

import logicClasses.Order_;

public class OrderCreationMenu {
	Scanner scan;
	OrderMenu upmenu;
	OrderCreationMenuHandling handler;

	OrderCreationMenu(Scanner scanIn, OrderMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new OrderCreationMenuHandling(scan, this);
	}

	void displaymenu() {
		String msg = "this is the order creation menu\n" + "you will be expected to know, Customer ID# &\n"
				+ "the Item ID#'s and item amounts for the order\n" + "enter number of option to continue\n"
				+ "1 : begin creating order\n" + "0 : return to Order Menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
	}

	void beginCreation() {
		String msg = "please enter CustmerID associated with this Order\n" + "or \"-0\" to return to creation menu";
		System.out.println(msg);
		Order_ newOrder;
		int choice = scan.nextInt();
		if (choice != -0) {
			newOrder = handler.processcustIdIn(choice);
			// sysout(" order "+newOrder.getId()+" Created, now begingin to add items to
			// order...");
			addItemstoOrder(newOrder);
			this.displaymenu();
		} else {
			this.displaymenu();
		}
	}

	boolean addItemstoOrder(Order_ orderHead) { // infinte loop here TODO
		// error intentional
		System.out
				.println("enter itemID# to add to order \n  or \"-0\" to return to creation menu and discard creation");
		int itemID = scan.nextInt();
		System.out.println("enter amount of items of " + itemID
				+ " to add to order\n or \"-0\" to return to creation menu and discard creation ");
		int itemAmo = scan.nextInt();

		if (handler.checkItem(itemID, itemAmo)) {// check if item and amo exists in DB // msg
			// Order.addItem( ........) //handle item creation (?????and db update of item
			// amo here?????)
			String lineString = handler.addItem(orderHead, itemID, itemAmo);
			System.out.println("Added : " + lineString);
			addItemstoOrder(orderHead);
		} else if (itemID == -0 || itemAmo == -0) {
			return false; //exit condition
		} // retry item input
		addItemstoOrder(orderHead);
		return true; //unreachable code required???
	}
}
