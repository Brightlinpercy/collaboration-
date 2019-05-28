package com.peopleconnect.CollaborationMiddleware.controller;


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

import com.peopleconnect.CollaborationBackend.Dao.BlogDao;
import com.peopleconnect.CollaborationBackend.Dao.LikeDislikeDao;
import com.peopleconnect.CollaborationBackend.Dao.UserDao;
import com.peopleconnect.CollaborationBackend.model.Blog;
import com.peopleconnect.CollaborationBackend.model.LikeDislike;

@RestController
@RequestMapping("/blog")
public class BlogController {
	@Autowired
	BlogDao blogDao;
	@Autowired
	UserDao userdao;
	@Autowired
	LikeDislikeDao likedislikedao;

	@PostMapping
	ResponseEntity<Void> createBlog(@RequestBody Blog blog, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			blog.setUser(userdao.getUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			
			if (blogDao.addBlog(blog))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);

		}
	}

	@DeleteMapping("/{blogid}")
	ResponseEntity<Blog> deleteBlog(@PathVariable("blogid") int blogid) {

		if (blogDao.deleteBlog(blogDao.getBlog(blogid)))
			return new ResponseEntity<Blog>(HttpStatus.ACCEPTED);
		else
			return new ResponseEntity<Blog>(HttpStatus.NOT_ACCEPTABLE);
	}

	@PostMapping("/updateBlog")
	ResponseEntity<Void> updateBlog(@RequestBody Blog blog, HttpSession httpSession) {
		if (httpSession.getAttribute("userid") != null) {
			blog.setUser(userdao.getUser(Integer.parseInt(httpSession.getAttribute("userid").toString())));
			
			if (blogDao.updateBlog(blog))
				return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
			else
				return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		} else {
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}

	}

	@GetMapping
	ResponseEntity<List<Blog>> viewAllBlog() {
		List<Blog> blog = blogDao.listBlogs();
		if (blog.isEmpty())
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}

	@GetMapping("/{blogid}")
	ResponseEntity<Blog> viewOneBlog(@PathVariable("blogid") int blogid) {
		Blog blog = blogDao.getBlog(blogid);
		if (blog == null)
			return new ResponseEntity<Blog>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<Blog>(blog, HttpStatus.ACCEPTED);
	}

	@GetMapping("/approveBlog/{blogId}")
	ResponseEntity<String> approveBlog(@PathVariable("blogid") int blogid) {
		Blog blog = blogDao.getBlog(blogid);
		if (blogDao.approveBlog(blog)) {
			return new ResponseEntity<String>("Blog approved", HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<String>("Blog is not approved", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/rejectBlog/{blogId}")
	ResponseEntity<String> rejectBlog(@PathVariable("blogid") int blogid) {
		Blog blog = blogDao.getBlog(blogid);
		if (blogDao.rejectBlog(blog)) {
			return new ResponseEntity<String>("Blog rejected", HttpStatus.ACCEPTED);

		} else {
			return new ResponseEntity<String>("Blog is not rejected", HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/approved")
	ResponseEntity<List<Blog>>selectApprovedBlog() {
		List<Blog> blog = blogDao.selectApprovedBlog();
		if (blog.isEmpty())
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}
	@GetMapping("/user/{userid}")
	ResponseEntity<List<Blog>> selectUserBlog(@PathVariable("userid") int userid) {
		List<Blog> blog = blogDao.selectUserBlog(userid);
		if (blog == null)
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.NOT_ACCEPTABLE);
		else
			return new ResponseEntity<List<Blog>>(blog, HttpStatus.ACCEPTED);
	}
	@PostMapping("/likedislike")
	ResponseEntity<Void> InsertOrUpdateBlogLike(@RequestBody LikeDislike likedislike)
	{
		if(likedislikedao.updateLikeDislike(likedislike))
		{
			return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
		}
		else
		{
			return new ResponseEntity<Void>(HttpStatus.NOT_ACCEPTABLE);
		}
	}
	@GetMapping("/likedislike/{blogid}")
	ResponseEntity<LikeDislike> getBloglikes(@PathVariable("blogid") int blogid)
	{
		LikeDislike lblog=likedislikedao.selectLikeDislike(blogid);
				
		if(lblog!=null)
		{
			return new ResponseEntity<LikeDislike>(lblog,HttpStatus.ACCEPTED);
		}
		else
		{
			LikeDislike lblog1=new LikeDislike();
			lblog1.setBlog(blogDao.getBlog(blogid));
			return new ResponseEntity<LikeDislike>(lblog1,HttpStatus.NOT_ACCEPTABLE);
			
		}
	}


}

