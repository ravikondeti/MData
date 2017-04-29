package com.rest.sample.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetPlcDataFromDB {

		//List<PlcDataTest> plcDataList =null;
		//PlcDataTest plcDataTest =null;
		
		public List<PlcDataTest> getPlcData(){
			PlcDataTest plcDataTest =null; 
			List<PlcDataTest> plcDataList =null;
		try{  
			plcDataTest =new PlcDataTest(null,null,0);
		Class.forName("com.mysql.jdbc.Driver");  
		Connection con=DriverManager.getConnection(  
		"jdbc:mysql://plcdata.cwpvkjc9qgvd.ap-south-1.rds.amazonaws.com:3306/PLC_DATA","RaviKondeti","RaviKondeti");  
		
		//here sonoo is database name, root is username and password  
		Statement stmt=con.createStatement();  
		ResultSet rs=stmt.executeQuery("select * from userdata"); 
		System.out.println("Got data from DB");
		while(rs.next()) {
			System.out.println("getting data");
			 //plcDataTest =new PlcDataTest(rs.getString(1),rs.getString(2),rs.getInt(3));
		
			plcDataList =new ArrayList<PlcDataTest>();
			System.out.println("Adding data to list");
			plcDataList.add(plcDataTest);
			System.out.println("Data added to list");
			System.out.println(plcDataList.get(0));
		System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getInt(3));  
		}
		con.close();  
		}catch(Exception e){ System.out.println(e);} 
		return plcDataList;
		}  
		
//		public static void main(String args[]){
//			try{
//				Class.forName("com.mysql.jdbc.Driver");
//				Connection con =DriverManager.getConnection(
//						"jdbc:mysql://plcdata.cwpvkjc9qgvd.ap-south-1.rds.amazonaws.com:3306/PLC_DATA","RaviKondeti","RaviKondeti");
//				Statement stmt =con.createStatement();
//				stmt.executeUpdate("Insert into userdata (firstname,secondname,age) values('manasvi','kondeti',2)");
//				ResultSet rs =stmt.executeQuery("select * from userdata");
//			while (rs.next())
//			System.out.println(rs.getString(1) + "  "+rs.getString(2)+ "  " +rs.getInt(3));	
//			con.close();
//			
//			}catch (Exception e) {
//				System.out.println(e);
//			} 
//				
//		}
	
}
