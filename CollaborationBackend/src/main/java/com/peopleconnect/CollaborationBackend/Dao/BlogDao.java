package com.peopleconnect.CollaborationBackend.Dao;

import java.util.List;

import com.peopleconnect.CollaborationBackend.model.Blog;
import com.peopleconnect.CollaborationBackend.model.LikeDislike;

public interface BlogDao {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
    public Blog getBlog(int blogid);
    public List<Blog> listBlogs();
    
    public boolean approveBlog(Blog blog);
    public boolean rejectBlog(Blog blog);
    public List<Blog>selectApprovedBlog();
    public List<Blog>selectUserBlog(int userid);
   
}