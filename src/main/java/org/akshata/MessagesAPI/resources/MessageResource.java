package org.akshata.MessagesAPI.resources;

import java.net.URI;
import java.util.List;

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

import org.akshata.MessagesAPI.model.Message;
import org.akshata.MessagesAPI.service.MessageService;

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	MessageService service = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages(@QueryParam("year") int yr, @QueryParam("start") int start, @QueryParam("size") int size){
		if(yr > 0){
			return service.getAllMessagesForYear(yr);
		}
		if(start >= 0 && size > 0){
			return service.getAllMessagesPaginated(start, size);
		}
		return service.getAllMessages();
	}
	
	@GET
	@Path("/{messageID}")
	public Message getMessage(@PathParam("messageID") long messageID){
		return service.getMessage(messageID);
	}
	
	//Adding a header with location URI and adding a status code of 201 after Message creation
	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo) {	
		Message newMessage = service.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI uri = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(uri).entity(newMessage).build();
	}

//	@POST
//	public Message addMessage(Message message){
//		return service.addMessage(message);
//	}
	
	@PUT
	@Path("/{messageID}")
	public Message updateMessage(@PathParam("messageID") long messageID, Message message){
		message.setId(messageID);
		return service.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageID}")
	public void deleteMessage(@PathParam("messageID") long messageID, Message message){
		service.removeMessage(messageID);
	}
	
}
