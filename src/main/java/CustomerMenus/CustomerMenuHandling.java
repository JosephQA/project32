 

import java.util.Scanner;

public class CustomerMenuHandling {
	Scanner scan;
	CustomerMenu upmenu;
	public CustomerMenuHandling(Scanner scanIn, CustomerMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}
	protected void handleMenuInput(int intput) {
		switch (intput) {
		case 1: 
			System.out.println("you want to create a customer\n");
			//do that
			//and reuturn
			CustomerAdditionMenu custAdd = new CustomerAdditionMenu(scan, upmenu);
			custAdd.startAdding();
			break;
		case 2: 
			System.out.println("you want to delete a customer\n");
			//do that
			CustomerDeletionMenu custDel = new CustomerDeletionMenu(scan, upmenu);
			custDel.startDeleting();
			//upmenu.displaymenu(); handled in custDel now
			break;
		case 3: 
			System.out.println("you want to change a customers details\n");
			//do that
			CustomerChangeMenu custChg = new CustomerChangeMenu(scan, upmenu);
			custChg.startChanging();
			upmenu.displaymenu();
			break;
		case 4: System.out.println("you want to view all customers\n");
		//do that
		CustomerViewMenu custView = new CustomerViewMenu(scan, upmenu);
		custView.startViewing();
			upmenu.displaymenu();
			break;
		case 9: System.out.println("you want to recover a customer with their ID\n");
		//do that
			upmenu.displaymenu();
			break;
		case 0: System.out.println("exiting customer menu \n");
			upmenu.upmenu.displayMenu();
			break;
		default: 
			System.out.println("input not recognised \n enter number of menu option ");
		    //consider idiot handling, max failure tries.
			upmenu.displaymenu();
		    break;
//		default: System.out.println("not recognised: enter 1, 2, 3, 4, 9 or 0");
//			//excessive loopback handling.....?
//			int take2 =scan.nextInt();
//			handleMenuInput(take2);
			
			
		}
	}

}
