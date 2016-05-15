package org.akshata.MessagesAPI.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.akshata.MessagesAPI.database.DataBase;
import org.akshata.MessagesAPI.model.Profile;

public class ProfileService {
	private static Map<String, Profile> profiles = DataBase.getProfiles();
	
		// Inserting a few profiles into profiles
		public ProfileService(){
			profiles.put("jane", new Profile(11,"jane","Jane", "Smith"));
			profiles.put("john", new Profile(22,"john","John", "Doe"));
		}
		
		public List<Profile> getAllProfiles(){
			return new ArrayList<Profile>(profiles.values());		
		}
		
		// Gets the profile
		public Profile getProfile(String profileName){
			return profiles.get(profileName);
		}
		
		// Creates and sets an id, adds the id and profile, and returns the profile created
		public Profile addProfile(Profile profile){
			profile.setId(profiles.size() + 1);
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		
		/*
		 * If id is less than 0, return null, otherwise put the new profile in place of the old one
		 * and return it
		 */
		public Profile updateProfile(Profile profile){
			if(profile.getProfileName().isEmpty()){
				return null;
			}
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
		
		// Return the profile instance that was removed
		public Profile removeProfile(String profileName){
			return profiles.remove(profileName);
		}

}
