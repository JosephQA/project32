 package  ItemMenus;
import java.util.Scanner;

public class ItemCreationMenuHandling {
	Scanner scan;
	ItemCreationMenu upmenu;
	ItemCreationMenuHandling(Scanner scanIn, ItemCreationMenu obj){
		scan = scanIn;
		upmenu = obj;
	}
	void handleMenuInput(int intput) {
		switch(intput) {
		case 1: 
			upmenu.startAdding();
			break;
		case 0:
			break;
		}
	}
	void handleAddingItem(String itemName, String ItemType, Double itemSalePrice, int itemAmount) {
		//call DBhandler to add item with input paremters
//		if success "item added to DB!!!"
		//if fail "item not added to db + error msg
		
	}
	

}
