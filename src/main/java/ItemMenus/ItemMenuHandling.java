 package  ItemMenus;

import java.util.Scanner;

public class ItemMenuHandling {
	Scanner scan;
	ItemMenu upMenu;

	ItemMenuHandling(Scanner scanIn,ItemMenu Itemmenu){
		scan = scanIn; upMenu = Itemmenu;
		}
	protected void handleMenuInput(int intput) {
		switch (intput) {
		case 1: System.out.println("you want to create an item");
				//do that
				ItemCreationMenu itemCreate = new ItemCreationMenu(scan,upMenu);
				itemCreate.displayMenu();
				upMenu.displaymenu();
				break;
		case 2:System.out.println("you want to delete an item");
		 		//do that
				ItemDeletionMenu itemDelete = new ItemDeletionMenu(scan, upMenu);
				itemDelete.displayMenu();
				upMenu.displaymenu();
				break;
		case 3:System.out.println("you want to change an item");
		 		//do that
				ItemChangeMenu itemChange = new ItemChangeMenu(scan, upMenu);
				itemChange.displayMenu();
				upMenu.displaymenu();
				break;
		case 4:System.out.println("you want to view all items");
		       //do that
				ItemViewMenu itemView = new ItemViewMenu(scan, upMenu);
				upMenu.displaymenu();
				break;
		case 9:System.out.println("you want to recover an item with its ID#");
		  		//do that
		System.out.println("not implemeted yet");
				upMenu.displaymenu();
				break;
		case 0: System.out.println("returning to main menu....");
				
				upMenu.upmenu.displayMenu();
				break;
		default: 
			System.out.println("input not recognised \n enter number of menu option ");
		    //consider idiot handling, max failure tries.
			upMenu.displaymenu();
		    break;
		} 	

	}
}
