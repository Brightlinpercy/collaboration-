package com.peopleconnect.CollaborationMiddleware.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

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

import com.peopleconnect.CollaborationBackend.Dao.ForumDao;
import com.peopleconnect.CollaborationBackend.Dao.UserDao;
import com.peopleconnect.CollaborationBackend.model.Forum;


@RestController
@RequestMapping("/forum")
public class ForumController {

	@Autowired
	ForumDao forumdao;

	@Autowired
	UserDao userdao;

	@PostMapping
	ResponseEntity<Void> createForum(@RequestBody Forum forum, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			forum.setUser(userdao.getUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			// forum.setComment_Date(new Date());
			if (forumdao.addForum(forum))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@PostMapping("/update")
	ResponseEntity<Void> updateForum(@RequestBody Forum forum, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			forum.setUser(userdao.getUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			// forum.setComment_Date(new Date());
			if (forumdao.updateForum(forum))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@DeleteMapping("/{forumid}")
	ResponseEntity<Forum> deleteBlog(@PathVariable("forumid") int forumid) {
		if (forumdao.deleteForum(forumdao.getForum(forumid)))
			return new ResponseEntity<Forum>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Forum>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping
	ResponseEntity<List<Forum>> viewAllForum() {
		List<Forum> forum = forumdao.listForums();
		if (forum.isEmpty())
			return new ResponseEntity<List<Forum>>(forum, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Forum>>(forum, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{forumid}")
	ResponseEntity<Forum> viewOneForum(@PathVariable("forumid") int forumid) {
		Forum forum = forumdao.getForum(forumid);
		if (forum == null)
			return new ResponseEntity<Forum>(forum, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Forum>(forum, HttpStatus.ACCEPTED);
	}}


