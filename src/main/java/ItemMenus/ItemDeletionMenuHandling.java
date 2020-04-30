package ItemMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Item_Handling;

public class ItemDeletionMenuHandling {
Scanner scan;
ItemDeletionMenu upmenu;
	public ItemDeletionMenuHandling(Scanner scanIn, ItemDeletionMenu obj) {
		scan = scanIn;
		upmenu = obj; 
		}
	void handleMenuInput(int intput) {
		switch(intput) {
		case 1:
			upmenu.continueDeleting();
			break;
		case 0:
			upmenu.upmenu.displaymenu();
			break;
		default: System.out.println("enter \"1\" or \"0\" to continue");
				upmenu.displayMenu();
			break;
		}
	}
	void handleDeleteing(int intput) {
		switch(intput) {
		case -0: 
			upmenu.displayMenu();
			break;
		default:
			if(deleteitem(intput)) {
				upmenu.success(intput);upmenu.displayMenu();break;
			}else {
				upmenu.fail();upmenu.displayMenu();
			}
			break;
		}
	}
	protected boolean deleteitem(int intput) {
		Factory f = Factory.getFactory();
		Item_Handling ih = f.getItemHandler();
		boolean bool = ih.deleteItem(intput);
		return bool;
		
	}
}
