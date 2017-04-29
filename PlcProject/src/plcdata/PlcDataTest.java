package plcdata;


import java.sql.*;
public class PlcDataTest {

	//Read data from MySQL Database
	
	public static void main(String args[]){  
	try{  
	Class.forName("com.mysql.jdbc.Driver");  
	Connection con=DriverManager.getConnection(  
	"jdbc:mysql://plcdata.cwpvkjc9qgvd.ap-south-1.rds.amazonaws.com:3306/PLC_DATA","RaviKondeti","RaviKondeti");  
	
	//here sonoo is database name, root is username and password  
	Statement stmt=con.createStatement();  
	ResultSet rs=stmt.executeQuery("select * from userdata");  
	while(rs.next()){  
		System.out.println("Got data from DB");
	System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3)); 
	}
	con.close();  
	}catch(Exception e){ System.out.println(e);}   
	}  
	
//	public static void main(String args[]){
//		try{
//			Class.forName("com.mysql.jdbc.Driver");
//			Connection con =DriverManager.getConnection(
//					"jdbc:mysql://plcdata.cwpvkjc9qgvd.ap-south-1.rds.amazonaws.com:3306/PLC_DATA","RaviKondeti","RaviKondeti");
//			Statement stmt =con.createStatement();
//			stmt.executeUpdate("Insert into userdata (firstname,secondname,age) values('manasvi','kondeti',2)");
//			ResultSet rs =stmt.executeQuery("select * from userdata");
//		while (rs.next())
//		System.out.println(rs.getString(1) + "  "+rs.getString(2)+ "  " +rs.getInt(3));	
//		con.close();
//		
//		}catch (Exception e) {
//			System.out.println(e);
//		} 
//			
//	}
}
