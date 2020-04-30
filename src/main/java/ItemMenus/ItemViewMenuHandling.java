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
			singleItem = getitem(intput);//new Item_(); //delete line later
		    msg ="Name: "+singleItem.getItemName()+
			"\nID  : "+singleItem.getItemId()+
			"\ncost: "+singleItem.getItemPrice()+"\n";
			
			
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
			 msg ="Name: "+ele.getItemName()+
						"\nID  : "+ele.getItemId()+
						"\ncost: "+ele.getItemPrice()+"\n";
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
