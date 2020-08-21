package com.example.demo;

import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Logs {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long pkid;   //Id Field doesn't appear in Response
	
	private String userId;
	private String sessionId;
	private String time;
	private String type;
	private HashMap<String, String> properties;  //HashMap since Quering over properties is not required
	
	
	
	//Constructors, Getters/Setters and ToString
	public Long getPkid() {
		return pkid;
	}
	public void setPkid(Long pkid) {
		this.pkid = pkid;
	}
	public Logs() {}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public HashMap<String, String> getProperties() {
		return properties;
	}
	public void setProperties(HashMap<String, String> properties) {
		this.properties = properties;
	}
	@Override
	public String toString() {
		return "Logs [userId=" + userId + ", sessionId=" + sessionId + ", time=" + time + ", type=" + type
				+ ", properties=" + properties + "]";
	}
	
	
	
	
}
