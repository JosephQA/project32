package OrderMenus;

import java.util.Scanner;

import logicClasses.Order_;

public class OrderCalcCostMenu {
Scanner scan;
OrderMenu upmenu;
OrderCalcCostMenuHandling handler;
public OrderCalcCostMenu(Scanner scanIn, OrderMenu obj) {
	// TODO Auto-generated constructor stub
	scan = scanIn;
	upmenu = obj;
	handler = new OrderCalcCostMenuHandling(scan, this);
}
void displayMenu(){
	String msg = "this is the order cost calculation menu\n"
			+ "enter orderID# to calculate that orders cost, or \"-0\" to return\n";
	System.out.println(msg);
	int choice = scan.nextInt();
	handler.handleMenuIntput(choice);
	Order_ order = handler.handleMenuIntput(choice);
	if(order != null) {
		String ordCost = handler.fetchCost(order);
		String msg2 = "Order:"/*+order.getId()+*/+" Costs:"+ordCost;
		System.out.println(msg2);
		upmenu.displayMenu();
	}else {
		//currently intentionally blank
		upmenu.displayMenu();
//		System.out.println("here");
		
	}
}
}
