 package enums;

public enum CustFields {
	ID("custId"),
	NAME1("firstname"),
	NAME2("lastname"),
	EMAIL("email"),
	FLAG("isDeleted");
	private String fld;
	CustFields(String envfld){ this.fld = envfld;}
	public String getFeild() {
		return fld;
	}
}
