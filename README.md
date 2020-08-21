Provide your comments on how you would make this solution cloud-scalable. 
	With a large amount of request coming in, there needs to a load balancer layer on top of the application layer with multiple data centers preferably in case one goes down. Databases are usually capable of handling large data and we can have backup to our database as a fail-safe. Another easy solution would be to use Services like AWS or Azure which handle load balancing themselves.
	
	

Challenge:  Terse set of requirements
	The requirements for the problem are vague, which was the challenge I faced. I first thought to have a multi-layered model. The top layer was log, which had a list of actions, which had properties. Since the logs are coming from the front-end, it is fair to assume that multiple logs can have same userId and sessionId. Because of this, I changed my design choice to have just one layered model. 
