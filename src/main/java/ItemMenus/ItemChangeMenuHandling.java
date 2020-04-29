 package  ItemMenus;

import java.util.Scanner;

import logicClasses.Item_;

public class ItemChangeMenuHandling {
Scanner scan;
ItemChangeMenu upmenu;
Item_ changeItem;
	public ItemChangeMenuHandling(Scanner scanIn, ItemChangeMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}
	void handleMenuIntput(int intput) {
		switch(intput) {
		case -0:
			upmenu.upmenu.displaymenu();
			break;
		default:
//			changeItem = Item.fetchFromDB(/*from intput ID#*/);
			changeItem = new Item_(); //delete this later for above line
			upmenu.continueChanging(changeItem);
			break;
		}
	}
	void handleChangeItem(int intput) {
		switch(intput) {
		case 1: System.out.println("enter new Item name \n");
			String newName = scan.nextLine();
			// try changeItem.setName(newName); updating DB
			upmenu.continueChanging(changeItem);
			break;
		case 2: System.out.println("enter new amount");
			int newAmo = scan.nextInt();
			//try changeItem.setAmount(newAmo); updating DB
			upmenu.continueChanging(changeItem);
			break;
		case 3: System.out.println("enter new cost per item");
			int newCostPI = scan.nextInt();
			//try changeItem.setCostPI(newCostPI); updating DB
			upmenu.continueChanging(changeItem);
			break;
		case 0:
			upmenu.upmenu.displaymenu();
			break;
		default: System.out.println("enter valid number of choice(1,2,3 or 0)");
			upmenu.continueChanging(changeItem);
			break;
		
		}
	}
}
