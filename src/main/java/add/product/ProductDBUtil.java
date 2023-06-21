package add.product;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import com.mysql.jdbc.StatementImpl;

public class ProductDBUtil {
	
	private static Connection con = null;
	private static java.sql.Statement stmt = null;
	private static ResultSet rs = null;
	private static StatementImpl JDBCDataSource;
	
	
	public static List<Product> getProduct(String ID) {
		
		int convertedID = Integer.parseInt(ID);
		ArrayList<Product> pro = new ArrayList<>();
		
		try {
			
			con = (Connection) DBconnect.getConnection();
			stmt = con.createStatement();
			String sql = "select * from product";
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				int id = rs.getInt(1);
				String image = rs.getString(2);
				String name = rs.getString(3);
				String price = rs.getString(4);
				String code = rs.getString(5);
				String description = rs.getString(6);
				
				Product p = new Product(id,image,name,price,code,description);
				Product.add(p);
			}
			
		} catch (Exception e) {
			
		}
		
		return pro;	
	}

	public static boolean insertproduct(String imageFileName , String name ,String price , String code , String description ) {
		
		boolean isSuccess = false;
		
		try {
			con = (Connection) DBconnect.getConnection();
			stmt = (Statement) con.createStatement();			
			
			String sql = "insert into product values(0 , '"+imageFileName+"' ,'"+name+"' , '"+price+"' , '"+code+"', '"+description+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		return isSuccess;
	}

	public static boolean updateproduct1(String id ,String imageFileName , String name ,String price , String code , String description) {
		boolean isSuccess = false;
		
		try {
			con = (Connection) DBconnect.getConnection();
			stmt = (Statement) con.createStatement();			
			
			
			String sql = "update product set ProductImage= '"+imageFileName+"' , ProductName= '"+name+"' ,ProductPrice= '"+price+"' , ProductCode=  '"+code+"', ProductDescription= '"+description+"'"+" where ProductID = '"+id+"'";
			
			int rs = stmt.executeUpdate(sql);
			
			if(rs > 0) {
				isSuccess = true;
			}
			else {
				isSuccess = false;
			}
			
		}
		catch(Exception e){
			
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Product> getProductDetails(String Id){
		
		int convertedID = Integer.parseInt(Id);
		ArrayList<Product> pro = new ArrayList<>();
		
		  try {
			  
			  con = (Connection) DBconnect.getConnection();
			  stmt = (Statement) con.createStatement();
			  String sql = "select * from product where ProductID = '"+convertedID+"'";
			  rs = stmt.executeQuery(sql);
					  
		    while (rs.next()) {
		    
		    int id = rs.getInt(1);
			String name = rs.getString(2);
			String image = rs.getString(3);
			String price = rs.getString(4);
			String code = rs.getString(5);
			String description = rs.getString(6);
			
			Product p = new Product(id, image,  name,  price,  code,  description);
			pro.add(p);
		    
			
		    
		    }
		  } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		  }
		  return pro;
		}

}
