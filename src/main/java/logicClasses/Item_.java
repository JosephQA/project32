package logicClasses;

public class Item_ {
	private int itemId = 0;
	private String ItemName;
	private int ItemId;
	private int ItemAmo;
	private double itemPrice;

	public Item_(String ItemNameIn, int itemIdIn, int ItemAmoIn, double itemPriceIn) {
		ItemName = ItemNameIn;
		ItemId = itemIdIn;
		ItemAmo = ItemAmoIn;
		itemPrice = itemPriceIn;
	}

//	protected Item_(String ItemNameIn, int itemIdIn, int ItemAmoIn, double itemPriceIn) {
//		ItemName = ItemNameIn;
//		ItemId = itemIdIn;
//		ItemAmo = ItemAmoIn;
//		itemPrice = itemPriceIn;
//	}

	protected Item_(int ItemIdIn, String ItemNameIn, int itemIdIn, int ItemAmoIn, double itemPriceIn) {
		itemId = itemIdIn;
		ItemName = ItemNameIn;
		ItemId = itemIdIn;
		ItemAmo = ItemAmoIn;
		itemPrice = itemPriceIn;
	}

	public int getItemAmo() {
		return ItemAmo;
	}

	public int getItemId() {
		return ItemId;
	}

	public String getItemName() {
		return ItemName;
	}

	public double getItemPrice() {
		return itemPrice;
	}

	protected void setItemAmo(int itemAmo) {
		ItemAmo = itemAmo;
	}

	protected void setItemId(int itemId) {
		ItemId = itemId;
	}

	protected void setItemName(String itemName) {
		ItemName = itemName;
	}

	protected void setItemPrice(double itemPrice) {
		this.itemPrice = itemPrice;
	}

}
