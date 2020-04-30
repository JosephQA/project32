package CustomerMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Customer_;
import logicClasses.Customer_Handling;

public class CustomerAdditionMenuHandling {
	Scanner scan;
	CustomerAdditionMenu upmenu;

	public CustomerAdditionMenuHandling(Scanner scanIn, CustomerAdditionMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}

	void handleMenuInput(int intput, String firstname, String lastname, String emailadress) {
		switch (intput) {
		case 1:
			Customer_Handling csth = getcusthan();
			Customer_ c = addcust(csth, firstname, lastname, emailadress);
			if (c != null) {
				upmenu.success(c.getId());
			} else {
				upmenu.fail();
			}
			upmenu.upmenu.displaymenu();
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
			handleMenuInput(choice, firstname, lastname, emailadress);
			break;
		}
	}

	private Customer_ addcust(Customer_Handling csth, String firstname, String lastname, String emailadress) {
		Customer_ c = new Customer_(firstname, lastname, emailadress);

		return csth.createCust(c);

	}

	private Customer_Handling getcusthan() {
		Factory f = Factory.getFactory();
		Customer_Handling csth = f.getCustomerHandler();
		return csth;
	}
}
