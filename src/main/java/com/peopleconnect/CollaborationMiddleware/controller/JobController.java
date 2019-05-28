package com.peopleconnect.CollaborationMiddleware.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peopleconnect.CollaborationBackend.Dao.JobDao;
import com.peopleconnect.CollaborationBackend.model.Job;

@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobDao jobdao;
	
	@PostMapping
	ResponseEntity<Void> createJob(@RequestBody Job job) {
		// job.setPublished_Date(new Date());
		if (jobdao.addJob(job))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateJob(@RequestBody Job job) {
		// job.setPublished_Date(new Date());
		if (jobdao.updateJob(job))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@DeleteMapping("/{jobid}")
	ResponseEntity<Job> deleteJob(@PathVariable("jobid") int jobid)
	{
		if(jobdao.deleteJob(jobdao.getOneJob(jobid)))
			return new ResponseEntity<Job>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Job>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping
	ResponseEntity<List<Job>> viewAllJob()
	{
		List<Job> job=jobdao.selectAllJob(); 
		if(job.isEmpty())
			return new ResponseEntity<List<Job>>(job,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Job>>(job,HttpStatus.ACCEPTED); 
	}

	@GetMapping("/{jobid}")
	ResponseEntity<Job> viewOneJob(@PathVariable("jobid") int jobid) {
		Job job = jobdao.getOneJob(jobid);
		if (job == null)
			return new ResponseEntity<Job>(job, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Job>(job, HttpStatus.ACCEPTED);
	}
	
	

}


