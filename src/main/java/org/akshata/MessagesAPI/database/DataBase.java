package org.akshata.MessagesAPI.database;

import java.util.HashMap;
import java.util.Map;

import org.akshata.MessagesAPI.model.Message;
import org.akshata.MessagesAPI.model.Profile;

//This is our stub for a database.
public class DataBase {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
}
