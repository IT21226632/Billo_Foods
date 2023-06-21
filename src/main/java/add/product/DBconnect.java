package add.product;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBconnect {
	private static String url = "jdbc:mysql://localhost:3306/product";
	private static String userName = "root";
	private static String password = "it21226632";
	private static Connection con;
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url , userName , password);
		}
		catch(Exception e) {
			System.out.println("connection fail!!");
		}
		
		return con;
	}
}
