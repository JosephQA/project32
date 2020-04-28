package enums;

public enum OrderFields {
	ORDERID("orderID"),
	CUSTID("customer");
	
	private String fld;
	OrderFields(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
