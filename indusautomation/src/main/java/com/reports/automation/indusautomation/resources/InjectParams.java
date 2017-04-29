package com.reports.automation.indusautomation.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectparams")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectParams {

	@GET
	@Path("/params")
	public String getInjectParams(@MatrixParam("name") String name, @HeaderParam("headervalue") String headervalue){
		return "Name :" +name + "Header Param : " +headervalue
				;
	}
	
	@GET
	@Path("/context")
	public String getContext(@Context UriInfo uriInfo){
		String absPath =uriInfo.getAbsolutePath().toString();
		return absPath;
	}
	@GET
	@Path("/contextQryParams")
	public String getContextQryParams(@Context UriInfo uriInfo){
		String qryParams =uriInfo.getQueryParameters().toString();
		return qryParams;
	}
	@GET
	@Path("/{pathParam}")
	public String getContextPathParams(@PathParam("pathParam") String pathParam, @Context UriInfo uriInfo){
		String pathParams = uriInfo.getPathParameters().toString();
		return pathParams;
	}
	
	
	
}
