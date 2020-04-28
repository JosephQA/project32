package OrderMenus;

import java.util.Scanner;

import InitClass.HelloMenu;

public class OrderMenu {
	Scanner scan;
	HelloMenu upmenu;
	OrderMenuHandling handler;
	public OrderMenu(Scanner scanIn,HelloMenu obj){
		scan = scanIn;
		upmenu = obj;
		handler = new OrderMenuHandling(scan,this);
		}
	public void displayMenu() {
	String menuString = "this is the order handling menu\n"
			+ "enter number of option to continue \n\n"
			+ "1 : create an order\n"
			+ "2 : view all orders\n"
			+ "3 : delete an order\n"
			+ "4 : add item to order \n"
			+ "5 : calculate cost for order \n"
			+ "0 : return to main menu\n";
	System.out.println(menuString);
	int choice = scan.nextInt();
	handler.handleMenuInput(choice);
	}
	
}
