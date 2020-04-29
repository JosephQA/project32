 package  ItemMenus;

import java.util.Scanner;

public class ItemCreationMenu {
	Scanner scan;
	ItemMenu upmenu;
	ItemCreationMenuHandling handler;
	public ItemCreationMenu(Scanner scanIn, ItemMenu obj) {
		scan = scanIn;
		upmenu = obj;
		handler = new ItemCreationMenuHandling(scan, this);
		// TODO Auto-generated constructor stub
	}
	void displayMenu() {
		String msg = "this is the Item Creation Menu\n"
				+ "you want to create an item,  \n"
				+ "you will be expected to have ready: item name, type,sale price per item, number of items to add\n"
				+ "enter number of option to continue\n"
				+ "1 : begin creating item\n"
				+ "0 : return to item overview menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuInput(choice);
		upmenu.displaymenu();
	}
	void startAdding() {
		String msg = "beginning guided process to create an item\n";
		System.out.println(msg);
		System.out.println("Enter item name:");
		String itemName = scan.next();
		System.out.println("Enter item type:"); //enumeration here??
		String itemType = scan.next();
		System.out.println("Enter sale price per item:");
		double itemSalePrice = scan.nextDouble();
		System.out.println("enter number of items tp add");
		int itemAmount = scan.nextInt();
		handler.handleAddingItem(itemName,itemType,itemSalePrice,itemAmount);
	}

}
