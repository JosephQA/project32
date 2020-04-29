package  ItemMenus;

import java.util.ArrayList;
import java.util.Scanner;

import logicClasses.Item_;

public class ItemViewMenuHandling {
Scanner scan;
ItemViewMenu upmenu;
	public ItemViewMenuHandling(Scanner scanIn, ItemViewMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}
	void handleMenuInput(int intput) {
		switch(intput) {
		case 1: upmenu.viewOne();
			break;
		case 2: upmenu.viewAll();
			break;
		case 0:
			upmenu.upmenu.displaymenu();
			break;
		default: System.out.println("enter valid number of choice (1,2 or 0)");
		 	upmenu.displayMenu();
		 	break;
		}
	}
	String handleViewOne(int intput) {
		Item_ singleItem;
		String msg = "";
		if(intput != -0) {
//			singleItem = Item.fromID(intput); / DB.itemfromID(intput);
			singleItem = new Item_(); //delete line later
//		    msg ="Name: "+singleItem.getName()
//			"\nID  : "+singleItem.getID()
//			"\ncost: "+singleItem.getcostPI()+"\n";
			
		}else { msg = "returning...\n" ;}
		return msg;
	}
	ArrayList<String> handleViewAll(){
		ArrayList<String> msgArrL= new ArrayList<String>();
		//DB.getAllItemsStream ....{(ele -> String itemStr = ele.toString; //where ele is an ITEM object
			//msgArrL.add(itemStr); )}
		
		return msgArrL;
	}
}
