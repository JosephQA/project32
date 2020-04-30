package InitClass;

import java.util.Scanner;

import logicClasses.Database_;

public class Runner {

	public static void main(String[] args) {
		Scanner scan = ScannerHandling.getScanner();
		Factory f = new Factory();
		System.out.println("enter username, then enter password for DB");
		 Database_ db = f.getDatabase_();
//		 Database_ db = new Database_(scan);
//		db .checkConnection();
		HelloMenu hi = new HelloMenu(scan);
		hi.displayMenu();
		db.close();
	}

}
