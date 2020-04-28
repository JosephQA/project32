package enums;

public enum TableNames {
	ORDERS("orders"),
	PRODUCTS("items"),
	CUSTOMERS("customers"),
	ORDERLINES("orderline");
	private String fld;
	TableNames(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
