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
//		Order_Handling ordHan = f.getOrderHandler();
////		System.out.println("++TEST++");
	Order_ ordHead = gethead(orderID);
//		System.out.println("++TEST++");
		ArrayList<OrderLine_> ordlinArr = setuphandleviewone(orderID);
//		System.out.println("++TEST++");
		retStr = retStr + ordHead.toString()+"\n";
		for(OrderLine_ ele: ordlinArr) {
			retStr = retStr + ele.toString()+"\n";
		}
		return retStr;
		
	}
	protected Order_ gethead(int orderID) {
		Order_Handling ordHan = f.getOrderHandler();
//		System.out.println("++TEST++");
		Order_ ordHead = ordHan.getOrderbyId(orderID);
		return ordHead;
	}
	protected ArrayList<OrderLine_> setuphandleviewone(int orderID){
//		System.out.println("++TEST++");
		Order_Handling ordHan = f.getOrderHandler();
//		System.out.println("++TEST++");
		Order_ ordHead = ordHan.getOrderbyId(orderID);
//		System.out.println("++TEST++");
		ArrayList<OrderLine_> ordlinArr = f.getOrderlinehandler().getLinesbyOrder(orderID);
//		System.out.println("++TEST++");
		return ordlinArr;
	}
	protected ArrayList<String> viewAll(){
		ArrayList<String> retArr = new ArrayList<String>();
		//fetch item....stream? from DB, for each item add item.toString to retArr
		Order_Handling ordhan = getordhan();
		OrderLine_handling linhan = getlinhan();
		ArrayList<Order_> ordArr = getordarr(ordhan);
		ArrayList<OrderLine_> linArr = new ArrayList<OrderLine_>();
		String ordNlinStr = "";
		for(Order_ order:ordArr) {
			ordNlinStr = ""+order.toString()+"\n";
			linArr.clear();
			
			linArr = getlinarr(linhan, order.getOrderId());
			for(OrderLine_ ele: linArr) {
				ordNlinStr = ordNlinStr + ele.toString()+"\n";
			}
			retArr.add(ordNlinStr);
		}
		
		return retArr;
	}
	protected Order_Handling getordhan() {
		return f.getOrderHandler();
	}
	protected OrderLine_handling getlinhan() {
		return f.getOrderlinehandler();
	}
	protected ArrayList<Order_> getordarr(Order_Handling ordh){
		return ordh.getAllOrder();
	}
	protected ArrayList<OrderLine_> getlinarr(OrderLine_handling linh, int orderID){
		return linh.getLinesbyOrder(orderID);
	}

}
