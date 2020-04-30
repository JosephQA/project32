package OrderMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Order_Handling;

public class OrderDeletionMenuHandling {
	Scanner scan;
	OrderDeletionMenu upmenu;
	Factory f = Factory.getFactory();

	public OrderDeletionMenuHandling(Scanner scanIn, OrderDeletionMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}

	protected void handleMenuInput(int intput) {
		switch (intput) {
		case 1:
			upmenu.beginDeletion();
			break;
		case 0:
			upmenu.upmenu.displayMenu();
			break;
		default:
			System.out.println("enter a valid choice \"1\" or \"0\" ");
			upmenu.displayMenu();
			break;
		}
	}

	protected boolean handleDeleteInput(int intput) {
		if (intput != -0) {
			// DB.deleteItem(intput) //check exists, then set isdeleted tru....
			// syso(result of deletion);
			// then
			Order_Handling ordhan = f.getOrderHandler();
			if (ordhan.deleteOrder(intput)) {
				System.out.println("order deleted ");
				upmenu.displayMenu();
				return true;
			} else {
				System.out.println("order deletion failed");
				upmenu.displayMenu();
				return false;
			}

		} else {
			upmenu.displayMenu();
			return true;
		}

	}
}
