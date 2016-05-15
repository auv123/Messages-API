package org.akshata.MessagesAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.akshata.MessagesAPI.database.DataBase;
import org.akshata.MessagesAPI.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DataBase.getMessages();
	
	// Inserting a few messages into messages
	public MessageService(){
		messages.put((long) 1, new Message(1,"Hello", "Jane"));
		messages.put((long) 2, new Message(2,"Hi", "John"));
	}
	
	public List<Message> getAllMessages(){
		return new ArrayList<Message>(messages.values());		
	}
	
	// Gets the message
	public Message getMessage(long id){
		return messages.get(id);
	}
	
	// Creates and sets an id, adds the id and message, and returns the message created
	public Message addMessage(Message message){
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	/*
	 * If id is less than 0, return null, otherwise put the new message in place of the old one
	 * and return it
	 */
	public Message updateMessage(Message message){
		if(message.getId() <= 0){
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	// Return the message instance that was removed
	public Message removeMessage(long id){
		return messages.remove(id);
	}

}
