package com.reports.automation.indusautomation.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.reports.automation.indusautomation.database.DatabaseClass;
import com.reports.automation.indusautomation.model.Profile;

public class ProfileService {

private Map<String, Profile> profiles = DatabaseClass.getProfiles();

public ProfileService(){
	profiles.put("ravi", new Profile(1l,"ravi","ravi","kondeti"));
}
public List<Profile> getProfiles(){
	return new ArrayList<Profile>(profiles.values()) ;
	}

public Profile getProfile(String profileName){
	return profiles.get(profileName);
}

public Profile addProfile(Profile profile){
	profile.setId(profiles.size() +1);
	profiles.put(profile.getProfileName(), profile);
	return profile;
}

public Profile updateProfile(Profile profile){
	if(profile.getProfileName().isEmpty()){
		return null;
	}
	profiles.put(profile.getProfileName(), profile);
	return profile;
}

}
