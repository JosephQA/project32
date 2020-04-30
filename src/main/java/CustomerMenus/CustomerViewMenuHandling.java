package CustomerMenus;

import java.util.ArrayList;
import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Customer_;
import logicClasses.Customer_Handling;

public class CustomerViewMenuHandling {
	Scanner scan;
	String longstr ="";
	CustomerViewMenu upmenu;
	CustomerViewMenuHandling(Scanner scanIn,CustomerViewMenu obj){
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
				String stri =startSingleFetch(idNo);
				upmenu.success(stri);
				//viewmenu.startViewing();
				upmenu.startViewing();
			}else {upmenu.startViewing();}
			break;
		case 2:
			String stre = getallcustString(); 
			upmenu.success(stre);
			//fetch all customers from DB
			//display all custmers
			upmenu.startViewing();
			break;
		case 0: upmenu.upmenu.displaymenu(); break;
		
		default: upmenu.startViewing(); break;
		}
	}
	String startSingleFetch(int custID){
		//check if exists ( true::sysout("this id "+idNo+" doesnotexist")
		//fetch from db
		//cast and print values
		String str  =getcustString(custID);
		return str;
	}
	private String getcustString(int custID) {
		Customer_Handling csth = getcusthan();
		Customer_ cst = csth.getCustomer(custID);
		if(cst!=null) {
			return cst.toString();
		}else {return "NOT FOUND";}
		
	}
	private String getallcustString() {
		ArrayList<Customer_> cstarr = startAllFetch();
		if(cstarr.isEmpty()) {return "NONE FOUND";}
		cstarr.forEach(ele-> {longstr = longstr+ele.toString();});
		return longstr;
	}
	ArrayList<Customer_> startAllFetch() {
		Customer_Handling csth = getcusthan();
		ArrayList<Customer_> cstarr = csth.getAllCusts();
		return cstarr;
	}
	private Customer_Handling getcusthan() {
		Factory f = Factory.getFactory();
		Customer_Handling csth = f.getCustomerHandler();
		return csth;
	}
	
	
}
