package com.example.demo;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



// Controller Class to Define All Needed Endpoints
@RestController
public class LogsController {
	
	//Repository need to perform CRUD Operations on DataBase
	@Autowired
	LogsRepo logsRepo;
	
	//Mapping from Json to Logs(POJO)
	@Autowired
	MappingService mapSerivce;
	
	//Post Endpoint to Accept incoming Log in JSON format and Store it in DataBase
	@PostMapping("/api/accept-log")
	public ResponseEntity<String> Log(@RequestBody Map<String, Object> payload)
	{
		List<Logs> logs ;
		try {
		logs = mapSerivce.LogsMapper(payload); 
		} catch(Exception e) {
			return new ResponseEntity<String>("Wrong Format for Body", HttpStatus.BAD_REQUEST);
		}
		logsRepo.saveAll(logs);
		return new ResponseEntity<String>("Created Logs", HttpStatus.CREATED);
	}

	//Get Endpoint to return list of all Logs
	@GetMapping("/api/all-logs")
	public ResponseEntity<List<Logs>> Logs()
	{
		return new ResponseEntity<List<Logs>>(logsRepo.findAll(), HttpStatus.OK);
		//return logsRepo.findAll();
	}
	
	
	@GetMapping("/api/logs/userid/{userid}")
	public ResponseEntity<List<Logs>> byUserid(@PathVariable String userid)
	{	
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByUserId(userid), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given Time
	@GetMapping("/api/logs/time/{time}")
	public ResponseEntity<List<Logs>> byTime(@PathVariable String time)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByTime(time), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given type
	@GetMapping("/api/logs/type/{type}")
	public ResponseEntity<List<Logs>> byType(@PathVariable String type)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByType(type), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given type
	@GetMapping("/api/logs/userid/{userid}/type/{type}")
	public ResponseEntity<List<Logs>> byUserAndType(@PathVariable("userid") String userid, @PathVariable("type") String type)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByUserIdAndType(userid,type), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given type	
	@GetMapping("/api/logs/timerange/{mintime}/{maxtime}")
	public ResponseEntity<List<Logs>> byTimeRange(@PathVariable("mintime") String min, @PathVariable("maxtime") String max)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByTimeBetween(min, max), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given type	
	@GetMapping("/api/logs/userid/{userid}/timerange/{mintime}/{maxtime}")
	public ResponseEntity<List<Logs>> byUsrAndTimeRange(@PathVariable("userid") String userid, @PathVariable("mintime") String min, @PathVariable("maxtime") String max)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByTimeBetweenAndUserId(min, max, userid), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given type	
	@GetMapping("/api/logs/type/{type}/timerange/{mintime}/{maxtime}")
	public ResponseEntity<List<Logs>> byTypeAndTimeRange(@PathVariable("type") String type, @PathVariable("mintime") String min, @PathVariable("maxtime") String max)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByTimeBetweenAndType(min, max, type), HttpStatus.OK);
	}
	
	//Get Endpoint to return logs matching given type	
	@GetMapping("/api/logs/userid/{userid}/type/{type}/timerange/{mintime}/{maxtime}")
	public ResponseEntity<List<Logs>> byUsrAndTypeAndTimeRange(@PathVariable("userid") String userid, @PathVariable("type") String type, @PathVariable("mintime") String min, @PathVariable("maxtime") String max)
	{
		return new ResponseEntity<List<Logs>> (logsRepo.findAllByTimeBetweenAndUserIdAndType(min, max, userid, type), HttpStatus.OK);
	}

}
