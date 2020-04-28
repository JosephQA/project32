package OrderMenus;

import java.util.Scanner;

public class OrderViewMenu {
	Scanner scan;
	OrderMenu upmenu;
	OrderViewMenuHandling handler;

	public OrderViewMenu(Scanner scanIn, OrderMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new OrderViewMenuHandling(scan, this);
	}

	public void displayMenu() {
		String msg = "this is the view orders menu\n" + "enter number of option to continue\n"
				+ "1 : view all orders \n" + "2 : view order by orderID# \n" + "0 : return to Order menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
		upmenu.displayMenu();
	}

	protected void viewOne() {
		String msg = "enter OrderID# or \"-0\"to return";
		System.out.println(msg);
		int choice = scan.nextInt();
		String str = handler.handleViewOne(choice);
		System.out.println(str);
	}

	protected void viewAll() {
		for (String ele : handler.viewAll()) {
			System.out.println(ele);
		}
	}
}
