package ItemMenus;

import java.util.Scanner;

import InitClass.Factory;
import enums.ProductFields;
import logicClasses.Item_;
import logicClasses.Item_Handling;

public class ItemChangeMenuHandling {
	Scanner scan;
	ItemChangeMenu upmenu;
	Item_ changeItem;

	public ItemChangeMenuHandling(Scanner scanIn, ItemChangeMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}

	void handleMenuIntput(int intput) {
		switch (intput) {
		case -0:
			upmenu.upmenu.displaymenu();
			break;
		default:
//			changeItem = Item.fetchFromDB(/*from intput ID#*/);
			changeItem = getItem(intput); // delete this later for above line
			if (changeItem != null) {
				upmenu.continueChanging(changeItem);
				break;
			} else {
				upmenu.noItem();
				upmenu.displayMenu();
				break;
			}

		}
	}

	private Item_ getItem(int intput) {

		Item_Handling ih = getitemHandler();
		Item_ i = ih.getItembyID(intput);
		return i;
	}

	private Item_Handling getitemHandler() {
		Factory f = Factory.getFactory();
		Item_Handling ih = f.getItemHandler();
		return ih;
	}

	void handleChangeItem(int intput, Item_ changeItem) {
		switch (intput) {
		case 1:
			System.out.println("enter new Item name \n");
			scan.nextLine();
			String newName = scan.nextLine();
			// try changeItem.setName(newName); updating DB
			if (changeName(newName, changeItem) != null) {
				upmenu.success(newName, changeItem);
			} else {
				upmenu.fail();
			}
			 upmenu.continueChanging(changeItem);
			//upmenu.displayMenu();
			break;
		case 2:
			System.out.println("enter new amount");
			scan.nextLine();
			int newAmo = scan.nextInt();
			// try changeItem.setAmount(newAmo); updating DB
			if (changeAmount(newAmo, changeItem) != null) {
				upmenu.success(newAmo + "", changeItem);
			} else {
				upmenu.fail();
			}
			 upmenu.continueChanging(changeItem);
			//upmenu.displayMenu();
			break;
		case 3:
			System.out.println("enter new cost per item");
			scan.nextLine();
			double newCostPI = scan.nextDouble();
			// try changeItem.setCostPI(newCostPI); updating DB
			// upmenu.continueChanging(changeItem);
			if (changePrice(newCostPI, changeItem) != null) {
				upmenu.success(newCostPI + "", changeItem);
			} else {
				upmenu.fail();
			}
			upmenu.continueChanging(changeItem);
			//upmenu.displayMenu();
			break;
		case 0:
			upmenu.upmenu.displaymenu();
			break;
		default:
			System.out.println("enter valid number of choice(1,2,3 or 0)");
			// upmenu.continueChanging(changeItem);
			upmenu.displayMenu();
			break;

		}
	}

	private Object changePrice(double newCostPI, Item_ changeItem2) {
		Item_Handling ih = getitemHandler();
		return ih.updateItem(changeItem2.getItemId(), ProductFields.PRICE, "" + newCostPI);
	}

	private Item_ changeName(String newName, Item_ changeItem2) {
		// TODO Auto-generated method stub
		Item_Handling ih = getitemHandler();
		return ih.updateItem(changeItem2.getItemId(), ProductFields.NAME, newName);
	}

	private Item_ changeAmount(int amo, Item_ changeitem) {
		Item_Handling ih = getitemHandler();
		return ih.updateItem(changeitem.getItemId(), ProductFields.AMOUNT, "" + amo);
	}
}
