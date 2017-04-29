package com.reports.automation.indusautomation;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/textdisplay")
public class SecondResource {
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String getText(){
		return "hello how are you!";
	}

}
