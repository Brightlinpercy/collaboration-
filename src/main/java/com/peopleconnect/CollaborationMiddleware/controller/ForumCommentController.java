package com.peopleconnect.CollaborationMiddleware.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.peopleconnect.CollaborationBackend.Dao.ForumCommentDao;
import com.peopleconnect.CollaborationBackend.model.ForumComment;

@RestController
@RequestMapping("/forumcomment")
public class ForumCommentController {

	@Autowired
	ForumCommentDao forumcommentdao;

	@PostMapping
	ResponseEntity<Void> createForumComment(@RequestBody ForumComment forumcomment) {
		// forumcomment.setForumcomment_Date(new Date());
		if (forumcommentdao.addForumComment(forumcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PutMapping("/updateForumComment/{forumcommentid}/{comment}")
	ResponseEntity<Void> updateForumComment(@PathVariable("forumcommentid") int forumcommentid,@PathVariable("comment") String forumComment) {
		ForumComment forumcomment=forumcommentdao.getForumComment(forumcommentid);
		// forumcomment.setForumcomment_Date(new Date());
		forumcomment.setForumcomment(forumComment);
		if (forumcommentdao.updateForumComment(forumcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

	}
	
	@DeleteMapping("/{forumcommentid}")
	ResponseEntity<ForumComment> deleteForumComment(@PathVariable("forumcommentid") int forumcommentid) {
		if (forumcommentdao.deleteForumComment(forumcommentdao
				.getForumComment(forumcommentid)))
			return new ResponseEntity<ForumComment>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<ForumComment>(HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping
	ResponseEntity<List<ForumComment>> listForumComment()
	{
		List<ForumComment> forumcomment=forumcommentdao.listForumComment(); 
		if(forumcomment.isEmpty())
			return new ResponseEntity<List<ForumComment>>(forumcomment,HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<ForumComment>>(forumcomment,HttpStatus.ACCEPTED); 
	}

}