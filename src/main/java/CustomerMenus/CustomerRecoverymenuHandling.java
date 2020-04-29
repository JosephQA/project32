 package CustomerMenus;

import java.util.Scanner;

public class CustomerRecoverymenuHandling {
	Scanner scan;
	CustomerMenu upmenu;
	CustomerRecoverymenuHandling(Scanner scanIn,CustomerMenu obj){
		scan = scanIn;
		upmenu = obj;
	}
	void handleMenuInput(int intput){
		switch(intput) {
		case 1: 
			System.out.println("Enter customer ID# or \"-0\" to exit");
			int custID = scan.nextInt();
			if(custID != -0) {
				startRecovery(custID);//
			}else {} //nothing
			break;
		case 0: 			
			break;
		default: break;
		}
	}
	void startRecovery(int custID){
		//Customer_ recovered = DatabaseHandler.recoverCust(custID); or some shit like that
		//basically, chck db for (existing==true && "is deleted flag"==true)
		//when true, fetch the record, set "is deleted flag"==false, generate a cust from the record, print cust details + "RECOVERED"
		//when false "customer with that ID has never existed, suggest create a new customer"
		
		
	}

}
