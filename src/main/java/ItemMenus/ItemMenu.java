 

import java.util.Scanner;

import InitClass.HelloMenu;

public class ItemMenu {
	Scanner scan;
	HelloMenu upmenu;
	ItemMenuHandling handler;
	public ItemMenu(Scanner scanIn,HelloMenu obj){
		scan = scanIn;
		upmenu =obj;
		handler = new ItemMenuHandling(scanIn, this);
		}
	public void displaymenu() {
		String menuString =( "this is the item handling menu \n"
				+ "enter number of option to continue \n \n"
				+ "1 : create an item\n"
				+ "2 : delete an item\n"
				+ "3 : change an items details\n"
				+ "4 : view all items\n"
				+ "9 : recover an item ( requires item ID# ) \n"
				+ "0 : return to main menu" );
		System.out.println(menuString);		
		int intput = scan.nextInt();		
		handler.handleMenuInput(intput); 
	}
}
