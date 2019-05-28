package com.peopleconnect.CollaborationMiddleware.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.peopleconnect.CollaborationBackend.Dao.UserDao;
import com.peopleconnect.CollaborationBackend.model.UserDetail;

@RestController
public class LoginController {

	@Autowired
	UserDao userdao;

	@PostMapping("/login")
	ResponseEntity<Void> loginpage(@RequestBody UserDetail userdetail, HttpSession httpSession) {
		UserDetail existinguser = userdao.getUserByEmail(userdetail.getEmailid());
		if (existinguser.getPassword().equals(userdetail.getPassword())) {
			httpSession.setAttribute("userid", existinguser.getUserid());
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
}


