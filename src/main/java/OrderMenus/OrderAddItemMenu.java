package OrderMenus;

import java.util.Scanner;

import logicClasses.Order_;

public class OrderAddItemMenu {
	Scanner scan;
	OrderMenu upmenu;
	OrderAddItemMenuHandling handler;

	OrderAddItemMenu(Scanner scanIn, OrderMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new OrderAddItemMenuHandling(scan, this);
	}

	public void displayMenu() {
		String msg = "this is the order add item menu\n" + "enter number of option to continue\n"
				+ "1 : add an item to an order\n" + "0 : return to order menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleDisplayMenu(choice);

	}

	protected void startAddingItem() {
		String msg = "enter Order ID# or \"-0\" to return";
		System.out.println(msg);
		int choice = scan.nextInt();
		if (choice == -0) {
			return;
		}
		Order_ toaddto = handler.orderInit(choice); // try this and catch not found exeption // syso "not found please
													// retry after checking order ID"; this.displaymenu();
		if (toaddto == null) {
			System.out.println("Order :" + choice + " not found");
			this.displayMenu();
		}
		String msg2 = "enter item ID to add to order";
		System.out.println(msg2);
		int itemId = scan.nextInt();
		String msg3 = "enter amount to add to order";
		System.out.println(msg3);
		int itemAmo = scan.nextInt();
		String failState;
		if (! handler.addItemtoOrder(toaddto, itemId, itemAmo)) {
			// failure to add
			failState = "item addition failure, check ID and availible amount before retry";
		} else {
			/* addition successful */ failState = "item addition success, item: " + itemId + ":" + itemAmo
					+ " added to order ";
		}
		String msg4 = "item adding process concluded with result:\n" + failState; // +success/fail state
		System.out.println(msg4);
		this.displayMenu();
	}
}
