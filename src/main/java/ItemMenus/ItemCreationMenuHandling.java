package ItemMenus;

import java.util.Scanner;

import InitClass.Factory;
import logicClasses.Item_;
import logicClasses.Item_Handling;

public class ItemCreationMenuHandling {
	Scanner scan;
	ItemCreationMenu upmenu;

	ItemCreationMenuHandling(Scanner scanIn, ItemCreationMenu obj) {
		scan = scanIn;
		upmenu = obj;
	}

	void handleMenuInput(int intput) {
		switch (intput) {
		case 1:
			upmenu.startAdding();
			break;
		case 0:
			break;
		}
	}

	int handleAddingItem(String itemName/*, String ItemType*/, Double itemSalePrice, int itemAmount) {
		boolean bool = false;
//		Factory f = Factory.getFactory();
//		Item_Handling ih = f.getItemHandler();
		Item_ i = createitem(itemName, itemSalePrice, itemAmount);//ih.createIteminDB(itemName,itemAmount, itemSalePrice);
		//call DBhandler to add item with input paremters
//		if success "item added to DB!!!"
		//if fail "item not added to db + error msg
		if(i!=null) {
			callsucces(i.getItemId()+":"+i.getItemName());return i.getItemId();
		}else {callfail();return -1;}
		
	}

	protected Item_ createitem(String itemName/* , String ItemType */, Double itemSalePrice, int itemAmount) {
		Factory f = Factory.getFactory();
		Item_Handling ih = f.getItemHandler();
		Item_ i = ih.createIteminDB(itemName, itemAmount, itemSalePrice);
		return i;
	}

	protected void callsucces(String str) {
		upmenu.success(str);
	}

	protected void callfail() {
		upmenu.fail();
	}

}
