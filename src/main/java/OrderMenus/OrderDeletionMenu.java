package OrderMenus;

import java.util.Scanner;

public class OrderDeletionMenu {
	Scanner scan;
	OrderMenu upmenu;
	OrderDeletionMenuHandling handler;
	OrderDeletionMenu(Scanner scanIn, OrderMenu obj){
		scan = scanIn;
		upmenu = obj;
		handler = new OrderDeletionMenuHandling(scan, this);
	}
	public void displayMenu() {
		String msg = "this is the order Deletion Menu\n"
				+ "enter number of option to continue\n"
				+ "1 : delete an item with its itemID#\n"
				+ "0 : return to Order menu";
				System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
		
	}
	protected void beginDeletion() {
		String msg = "enter Itemid# or \"-0\" to return\n";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleDeleteInput(choice);
				
	}

}
