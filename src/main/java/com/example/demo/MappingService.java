package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;


//Mapping Service For Converting Map to Logs Object so they can Stored in the Databse
@Service
public class MappingService {
	
	
	//Mapper Method
	public List<Logs> LogsMapper(Map<String, Object> payload) {

		//Extracting userid and sessionid to apply to split the Actions
		//into different logs
		String usrid = (String)payload.get("userId");
		String ssid = (String)payload.get("sessionId");
		
		
		final ObjectMapper mapper = new ObjectMapper();
		
		//extracting actions 
		List<Map<String, Object>> actions = (List<Map<String, Object>> )payload.get("actions");

		
		//Create and Populate List of Logs by spliting the actions
		List<Logs> logs = new ArrayList<Logs>();
		for (int i = 0; i < actions.size(); i++) {
			logs.add(mapper.convertValue(actions.get(i), Logs.class));
		}
		actions.clear();
		
		for (int i = 0; i < logs.size(); i++) {
			logs.get(i).setUserId(usrid);
			logs.get(i).setSessionId(ssid);
		}
		return logs;
 }
}
