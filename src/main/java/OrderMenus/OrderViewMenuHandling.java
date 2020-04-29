package OrderMenus;

import java.util.ArrayList;
import java.util.Scanner;

import InitClass.Factory;
import logicClasses.OrderLine_;
import logicClasses.OrderLine_handling;
import logicClasses.Order_;
import logicClasses.Order_Handling;

public class OrderViewMenuHandling {
	Scanner scan;
	OrderViewMenu upmenu;
Factory f;

	public OrderViewMenuHandling(Scanner scanIn, OrderViewMenu obj) {
		scan = scanIn;
		upmenu = obj;
		f = Factory.getFactory();
	}

	protected void handleMenuInput(int intput){
		switch(intput) {		
		case 1:
			upmenu.viewOne();
			break;
		case 2:
			upmenu.viewAll();
			break;
		case 0: upmenu.upmenu.displayMenu();
			break;
		default:
			System.out.println("enter valid input (\"1\",\"2\" or \"0\") ");
			upmenu.displayMenu();
			break;
		};
	}	
	protected String handleViewOne(int orderID) {
		String retStr = "";
		//do some shit
		//fetch item from DB attempt. success str+=item.toString. fail "item  not found"
//		System.out.println("++TEST++");
		Order_Handling ordHan = f.getOrderHandler();
//		System.out.println("++TEST++");
		Order_ ordHead = ordHan.getOrderbyId(orderID);
//		System.out.println("++TEST++");
		ArrayList<OrderLine_> ordlinArr = f.getOrderlinehandler().getLinesbyOrder(orderID);
//		System.out.println("++TEST++");
		retStr = retStr + ordHead.toString()+"\n";
		for(OrderLine_ ele: ordlinArr) {
			retStr = retStr + ele.toString()+"\n";
		}
		return retStr;
		
	}
	protected ArrayList<String> viewAll(){
		ArrayList<String> retArr = new ArrayList<String>();
		//fetch item....stream? from DB, for each item add item.toString to retArr
		Order_Handling ordhan = f.getOrderHandler();
		OrderLine_handling linhan = f.getOrderlinehandler();
		ArrayList<Order_> ordArr = ordhan.getAllOrder();
		ArrayList<OrderLine_> linArr = new ArrayList<OrderLine_>();
		String ordNlinStr = "";
		for(Order_ order:ordArr) {
			ordNlinStr = ""+order.toString()+"\n";
			linArr.clear();
			
			linArr = linhan.getLinesbyOrder(order.getOrderId());
			for(OrderLine_ ele: linArr) {
				ordNlinStr = ordNlinStr + ele.toString()+"\n";
			}
			retArr.add(ordNlinStr);
		}
		
		return retArr;
	}

}
