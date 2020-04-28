package ItemMenus;

import java.util.Scanner;

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
			//try to delete item(ID = intput) from DB (set isdeleted == tru)
			//sysout success/failure msg
			break;
		}
	}
}
