package com.peopleconnect.CollaborationMiddleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peopleconnect.CollaborationBackend.Dao.UserDao;
import com.peopleconnect.CollaborationBackend.model.UserDetail;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserDao userdao;

	@PostMapping
	ResponseEntity<Void> registerUser(@RequestBody UserDetail user) {

		if (userdao.registerUser(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateUser(@RequestBody UserDetail user) {
		if (userdao.updateUser(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/{userid}")
	ResponseEntity<UserDetail> viewOneUser(@PathVariable("userid") int userid) {
		UserDetail user = userdao.getUser(userid);
		if (user == null)
			return new ResponseEntity<UserDetail>(user, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<UserDetail>(user, HttpStatus.ACCEPTED);
	}

	@PostMapping("/online/{userid}")
	ResponseEntity<Void> makeOnLine(@PathVariable("userid") int userid) {
		UserDetail user = userdao.getUser(userid);
		if (userdao.makeOnline(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/offline/{userid}")
	ResponseEntity<Void> makeOffLine(@PathVariable("userid") int userid) {
		UserDetail user = userdao.getUser(userid);
		if (userdao.makeOffline(user))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	ResponseEntity<List<UserDetail>> viewAllUsers() {
		List<UserDetail> user = userdao.selectAllUsers();
		if (user.isEmpty())
			return new ResponseEntity<List<UserDetail>>(user, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<UserDetail>>(user, HttpStatus.ACCEPTED);
	}

}
