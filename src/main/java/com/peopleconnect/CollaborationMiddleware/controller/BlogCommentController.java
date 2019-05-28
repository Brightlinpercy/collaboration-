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

import com.peopleconnect.CollaborationBackend.Dao.BlogCommentDao;
import com.peopleconnect.CollaborationBackend.Dao.BlogDao;
import com.peopleconnect.CollaborationBackend.model.BlogComment;

@RestController
@RequestMapping("/blogcomment")
public class BlogCommentController {

	@Autowired
	BlogCommentDao blogcommentdao;
	
	@Autowired
	BlogDao blogdao;

	@PostMapping
	ResponseEntity<Void> addComment(@RequestBody BlogComment blogcomment) {
		// blogcomment.setBlogComment_Date(new Date());
		if (blogcommentdao.addBlogComment(blogcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PutMapping("/updateBlogComment/{blogcommentid}/{comment}")
	ResponseEntity<Void> updateComment(@PathVariable("blogcommentid") int blogcommentid,@PathVariable("comment")String blogComment) {
		BlogComment blogcomment=blogcommentdao.getBlogComment(blogcommentid);
		// blogcomment.setBlogComment_Date(new Date());
		blogcomment.setCommenttext(blogComment);
		if (blogcommentdao.updateBlogComment(blogcomment))
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
	}

	@DeleteMapping("/{blogcommentid}")
	ResponseEntity<BlogComment> deleteBlogComment(@PathVariable("blogcommentid") int blogcommentid) {
		if (blogcommentdao.deleteBlogComment(blogcommentdao.getBlogComment(blogcommentid)))
			return new ResponseEntity<BlogComment>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<BlogComment>(HttpStatus.NOT_ACCEPTABLE);
	}

	@GetMapping("/{blogid}")
	ResponseEntity<List<BlogComment>> viewAllBlogComment(@PathVariable("blogid") int blogid) {
		List<BlogComment> blogcomment = blogcommentdao.listBlogComment(blogid);
		if (blogcomment.isEmpty())
			return new ResponseEntity<List<BlogComment>>(blogcomment, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<BlogComment>>(blogcomment, HttpStatus.ACCEPTED);
	}
}
