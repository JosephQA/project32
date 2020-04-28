package ItemMenus;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemViewMenu {
	Scanner scan;
	ItemMenu upmenu;
	ItemViewMenuHandling handler;
	public ItemViewMenu(Scanner scanIn, ItemMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new ItemViewMenuHandling(scan, this);
	}
	void displayMenu() {
		String msg = "This is the item Viewing menu\n"
				+ "Enter number of option to continue\n"
				+ "1 : view single item with Item ID#\n"
				+ "2 : view all items \n"
				+ "0 : return to item menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
	}
	void viewOne() {
		String msg = "enter item ID# or \"-0\" to return";
		System.out.println(msg);
		int choice = scan.nextInt();
		System.out.println(handler.handleViewOne(choice));
	}
	void viewAll() {
		ArrayList<String> itemList =handler.handleViewAll();
		//for each element sysout(elememnt);
	}
}
