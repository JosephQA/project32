package CustomerMenus;

import java.util.Scanner;

public class CustomerAdditionMenuHandling {
	Scanner scan;
	CustomerAdditionMenu upmenu;
	public CustomerAdditionMenuHandling(Scanner scanIn, CustomerAdditionMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}
	void handleMenuInput(int intput) {
		switch (intput) {
		case 1:
			//try to add customer to DB
			break;
		case 2:
			upmenu.startAdding();
			break;
		case 0:
			upmenu.upmenu.displaymenu();
			break;
		default:
			System.out.println("enter 1,2 or 0 to add, retry, or discard customer");
			int choice = scan.nextInt();
			scan.nextLine();
			handleMenuInput(choice);
			break;
		}
	}
}
