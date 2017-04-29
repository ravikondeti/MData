package com.rest.sample.app;

import java.util.Iterator;
import java.util.List; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType;  
@Path("/UserService") 

public class UserService {  
	UserDao userDao = new UserDao(); 
	GetPlcDataFromDB getPlcDataFromDB = new GetPlcDataFromDB();
   @GET 
   @Path("/users") 
   @Produces(MediaType.APPLICATION_XML) 
   public List<User> getUsers(){ 
      return userDao.getAllUsers();
   }  
   @GET
   @Path("/plcdata")
   @Produces(MediaType.APPLICATION_XML)
   public List<PlcDataTest> getDataFromDB() {

	   List<PlcDataTest> plcData =  getPlcDataFromDB.getPlcData();
	   //PlcDataTest data =plcData.get(0);
	   return  plcData;
	// TODO Auto-generated method stub

}
}