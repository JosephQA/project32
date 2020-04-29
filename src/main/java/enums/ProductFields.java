 package enums;

public enum ProductFields {
	ID("itemId"),
	NAME("itemName"),
	AMOUNT("itemAmount"),
	PRICE("itemPrice"),
	FLAG("isDeleted");
	private String fld;
	ProductFields(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
