package ItemMenus;

import java.util.Scanner;

import logicClasses.Item_;

public class ItemChangeMenu {
Scanner scan;
ItemMenu upmenu;
ItemChangeMenuHandling handler;
	ItemChangeMenu(Scanner scanIn, ItemMenu obj){
		scan = scanIn;
		upmenu = obj;
		handler = new ItemChangeMenuHandling(scan, this);
	}
	void displayMenu() {
		String msg = "This is the item change menu\n"
				+ "enter ItemID# or \"-0\" to return";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleMenuIntput(choice);
				
	}
	void continueChanging(Item_ changeItem) {
		String msg =" changing Item " +changeItem.getItemId()
				+ "\n enter number of option to continue\n"
				+ "1 : change Item name _\n"+ changeItem.getItemName()
				+ "2 : change Item amount _ \n"+ changeItem.getItemAmo()
				+ "3 : change Item cost per item _ \n"+changeItem.getItemPrice()
				+ "0 : return to item menu";
		System.out.println(msg);
		int choice = scan.nextInt();
		handler.handleChangeItem(choice, changeItem);
		continueChanging(changeItem);
	}
	public void noItem() {
		System.out.println("the item ID input is not found in the database\ncheck existence and retry");
		
	}
	public void success(String newName,Item_ i) {
		// TODO Auto-generated method stub
		System.out.println("ITEM "+i.getItemId()+" CHANGE ->"+ newName);
	}
	public void fail() {
		System.out.println("Change Failure");
	}
}
