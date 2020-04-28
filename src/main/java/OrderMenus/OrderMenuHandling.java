package OrderMenus;

import java.util.Scanner;

public class OrderMenuHandling {
	Scanner scan;
	OrderMenu upmenu;

	public OrderMenuHandling(Scanner scanIn, OrderMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}

	protected void handleMenuInput(int intput) {
		switch (intput) {
		case 1:
			System.out.println("you want to create an order");
			// do that
			OrderCreationMenu orderCreat = new OrderCreationMenu(scan, upmenu);
			orderCreat.displaymenu();
//			upmenu.displayMenu();
			break;
		case 2:
			System.out.println("you want to view all orders");
			// do that
			OrderViewMenu orderView = new OrderViewMenu(scan, upmenu);
			orderView.displayMenu();
//			upmenu.displayMenu();

			break;
		case 3:
			System.out.println("you want to delete an order");
			// do that
			OrderDeletionMenu orderDel = new OrderDeletionMenu(scan, upmenu);
			orderDel.displayMenu();
//			upmenu.displayMenu();
			break;
		case 4:
			System.out.println("you want to add an item to an order");
			// do that
			OrderAddItemMenu orderAdd = new OrderAddItemMenu(scan, upmenu);
			orderAdd.displayMenu();
//			upmenu.displayMenu();
			break;
		case 5:
			System.out.println("you want to calculate the cost of an order");
			// do that
			OrderCalcCostMenu orderCalc = new OrderCalcCostMenu(scan, upmenu);
			orderCalc.displayMenu();
//			upmenu.displayMenu();
			break;
		case 0:
			System.out.println("you want to return to main menu");
			upmenu.upmenu.displayMenu();
			break;
		default:
			System.out.println("input not recognised \n enter number of menu option ");
			// consider idiot handling, max failure tries.
			upmenu.displayMenu();
			break;
		}
	}
}