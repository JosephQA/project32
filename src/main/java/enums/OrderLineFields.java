 package enums;

public enum OrderLineFields {
	ID("orderId"),
	LINE("line"),
	ITEM("itemId"),
	AMOUNT("itemAmount"),
	FLAG("isDeleted");
	private String fld;
	OrderLineFields(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
