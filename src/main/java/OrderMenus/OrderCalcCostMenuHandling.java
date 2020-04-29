package OrderMenus;

import java.util.ArrayList;
import java.util.Scanner;

import InitClass.Factory;
import logicClasses.OrderLine_;
import logicClasses.OrderLine_handling;
import logicClasses.Order_;
import logicClasses.Order_Handling;

public class OrderCalcCostMenuHandling {
	Scanner scan;
	OrderCalcCostMenu upmenu;
	Order_Handling ordhan;
	OrderLine_handling linhan;
	double pricer;
Factory f = new Factory();
	public OrderCalcCostMenuHandling(Scanner scanIn, OrderCalcCostMenu obj) {
		// TODO Auto-generated constructor stub
		scan = scanIn;
		upmenu = obj;
	}

	protected Order_ handleMenuIntput(int intput) {
		Order_ retOrder;
		ordhan = f.getOrderHandler();
		if (intput != -0) {
			// actually DB.getOrder(orderID) //syso(no order found on fail?? and return null

			retOrder = ordhan.getOrderbyId(intput);

		} else {
			// upmenu.upmenu.displayMenu();
			retOrder = null;
		}
		return retOrder;
	}

	protected String fetchCost(Order_ order) {
		String retCost = "";
		// int cost = order.calcCost();
		// retCost += cost;
		pricer = 0;
		linhan = f.getOrderlinehandler();
		ArrayList<OrderLine_> list = linhan.getLinesbyOrder(order.getOrderId());
		list.forEach(ele -> {
			pricer = pricer + linhan.getLinePrice(ele);
		});
		
		return ""+pricer;
	}
}
