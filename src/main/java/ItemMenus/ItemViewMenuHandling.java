package ItemMenus;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.plaf.basic.BasicComboBoxUI.ItemHandler;

import InitClass.Factory;
import logicClasses.Item_;
import logicClasses.Item_Handling;

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
			upmenu.displayMenu();
			break;
		case 2: upmenu.viewAll();upmenu.displayMenu();
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
			singleItem = getitem(intput);//new Item_(); //delete line later
		   if(singleItem != null) {
			msg =singleItem.toString();
		   }else {msg = "not a valid/existing item ID";}
			
		}else { msg = "returning...\n" ;}
		return msg;
	}
	ArrayList<String> handleViewAll(){
		ArrayList<String> msgArrL= new ArrayList<String>();
		//DB.getAllItemsStream ....{(ele -> String itemStr = ele.toString; //where ele is an ITEM object
			//msgArrL.add(itemStr); )}
		// msg = "";
		ArrayList<Item_> itemArr = getallitems();
		itemArr.forEach( ele ->{   
			String msg = "";
			 msg =ele.toString();
			 msgArrL.add(msg);
		} );
		
		return msgArrL;
	}
	protected Item_ getitem(int intput) {
		Factory f = Factory.getFactory();
		Item_Handling ih = f.getItemHandler();
		Item_ i = ih.getItembyID(intput);
		return i;
	}
	protected ArrayList<Item_> getallitems(){
		Factory f = Factory.getFactory();
		Item_Handling ih = f.getItemHandler();
		ArrayList<Item_> iarr= ih.getAllItems();
		return iarr;
	}
}
