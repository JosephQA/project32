package logicClasses;

public class Customer_ {
	private int id;
	private String firstname,lastname, email;
	protected Customer_( int iD, String name1, String name2 ,String emaill/*cust vars*/){
		id= iD; setFirstname(name1); setLastname(name2); setEmail(emaill);
		
	}
	
	
	
	
	
	public String getFirstname() {
		return firstname;
	}
	private void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	private void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	private void setEmail(String email) {
		this.email = email;
	}
	public int getId() {
		return id;
	}
	

}
