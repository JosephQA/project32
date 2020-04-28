package CustomerMenus;

import java.util.Scanner;

public class CustomerViewMenuHandling {
	Scanner scan;
	CustomerMenu upmenu;
	CustomerViewMenuHandling(Scanner scanIn,CustomerMenu obj){
		scan = scanIn;
		upmenu = obj;
	}
	protected void handleMenuInput(int intput,CustomerViewMenu viewmenu) {
		switch(intput) {
		case 1:
			System.out.println("enter Customer Id# now, or \"-0\" to return to Customer Veiwing Meun \n");
			int idNo = scan.nextInt();
			if(idNo != -0) {
				//fetch customer and show details
				startSingleFetch(idNo);
				viewmenu.startViewing();
			}else {viewmenu.startViewing();}
			break;
		case 2:
			startAllFetch(); 
			//fetch all customers from DB
			//display all custmers
			viewmenu.startViewing();
			break;
		case 0: upmenu.displaymenu(); break;
		
		default: upmenu.displaymenu(); break;
		}
	}
	void startSingleFetch(int custID){
		//check if exists ( true::sysout("this id "+idNo+" doesnotexist")
		//fetch from db
		//cast and print values
	}
	void startAllFetch() {
		//get all custs that are not "deleted"
		//cast to Customer_ and add to a List<Customer_>
		//print list values ....(format??)
	}
	
}
