package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


//JPA Repository Interface for CRUD Operations
public interface LogsRepo extends JpaRepository<Logs, Long>{
	
	//Using JPA Query Syntax to Query over different fields
	public List<Logs> findAllByUserId (String userId);
	public List<Logs> findAllByTime (String time);
	public List<Logs> findAllByType (String type);
	public List<Logs> findAllByUserIdAndType (String userId, String type);
	public List<Logs> findAllByTimeBetween (String start, String end);
	public List<Logs> findAllByTimeBetweenAndUserId (String min, String max, String userid);
	public List<Logs> findAllByTimeBetweenAndType (String min, String max, String type);
	public List<Logs> findAllByTimeBetweenAndUserIdAndType (String min,String max, String userid, String type);
}
