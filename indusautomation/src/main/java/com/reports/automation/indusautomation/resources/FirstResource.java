package com.reports.automation.indusautomation.resources;

import java.net.URI;
import java.util.List;

import javax.annotation.Generated;
import javax.ws.rs.BeanParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import com.reports.automation.indusautomation.model.Message;
import com.reports.automation.indusautomation.resources.beans.BeanParams;
import com.reports.automation.indusautomation.service.MessageService;

@Path("/messages")
public class FirstResource {
	MessageService messageService =new MessageService();
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@BeanParam BeanParams beanParams){
		if(beanParams.getYear() >0){
			return messageService.getMessagesByYear(beanParams.getYear());
		}
		if (beanParams.getStart()>=0 && beanParams.getStart() >=0){
			return messageService.getAllMessagesPaginated(beanParams.getStart(), beanParams.getSize());
		}
		return messageService.getMessages();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response addmessage(@Context UriInfo uriInfo, Message message){
		Message newMessage = messageService.addMessage(message);
		String newId =String.valueOf(message.getId());
		URI uri =uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri)
				.entity(newMessage)
				.build();
		//return messageService.addMessage(message);
	}
	
	@PUT
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Message updateMessage(@PathParam("messageId") long id, Message message){
		message.setId(id);
		return messageService.updateMessage(message);
	}
	@DELETE
	@Path("/{messageId}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public void deleteMessage(@PathParam("messageId") long id){
		messageService.delete(id);
	}
	
	@GET
	@Path("/{messageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Message getFirstMessage(@PathParam("messageId") long messageId){
		return messageService.getMessage(messageId);
	}
	
	
}
