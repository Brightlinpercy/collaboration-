package com.peopleconnect.CollaborationBackend.Dao;

import java.util.List;

import com.peopleconnect.CollaborationBackend.model.Blog;

public interface BlogDao {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean updateBlog(Blog blog);
    public Blog getBlog(int blogid);
    public List<Blog> listBlogs();
    
    public boolean approveBlog(Blog blog);
    public boolean rejectBlog(Blog blog);

    public boolean incrementLikes(Blog blog);
    public boolean incrementDislikes(Blog blog);
}