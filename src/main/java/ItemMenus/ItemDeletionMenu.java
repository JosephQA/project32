package ItemMenus;

import java.util.Scanner;

public class ItemDeletionMenu {
	Scanner scan;
	ItemMenu upmenu;
	ItemDeletionMenuHandling handler;
	public ItemDeletionMenu(Scanner scanIn, ItemMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new ItemDeletionMenuHandling(scan, this);
	}
	void displayMenu() {
		String msg = "This is the item deletion menu\n"
				+ "enter number of option to continue\n"
				+ "1 : delete an item with its ID#\n"
				+ "0 : return to item menu\n";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
	}
	void continueDeleting() {
		String msg = "enter ID# or \"-0\" to return";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleDeleteing(choice);
	}
	public void success(int id) {
		System.out.println("ITEM "+id+" DELETED");
		
	}
	public void fail() {
		System.out.println("DELETION FAILURE");
	}

}
