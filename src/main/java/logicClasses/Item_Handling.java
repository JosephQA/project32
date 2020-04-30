package logicClasses;

import java.util.ArrayList;

import InitClass.Factory;
import enums.ProductFields;

public class Item_Handling {
	private static Database_handling dbh;
	Factory f = Factory.getFactory();
	public Item_Handling() {
		dbh =f.getDatabaseHandling("");
		
		
	}
	public Item_Handling(String tst) {
		dbh = f.getDatabaseHandling(tst);
	}
//creaett
	public Item_ createIteminDB(int itemID,String name ,int amount,double price ) {
		return dbh.createFullItem(itemID,name,amount,price);
	}
	public Item_ createIteminDB(String name ,int amount,double price ) {
		return dbh.createItem(name,amount,price);
	}
//retreice
	public Item_ getItembyID(int ID) {
		return dbh.getItemById(ID);
	}
	public ArrayList<Item_> getItemsByName(String name){
		return dbh.getItemsbyName(name);
		
	}

//update
	public Item_ updateItem(int iD,ProductFields fld, String value) {
		return dbh.updateItem(iD, fld, value);
	}
//DElete
	public boolean deleteItem(int iD) {
		return dbh.deleteItem(iD);
	}
	public ArrayList<Item_> getAllItems() {
		
		return dbh.getAllItems();
	}
}
