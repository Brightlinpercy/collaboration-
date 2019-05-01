package com.peopleconnect.CollaborationBackend.Dao;

import java.util.List;

import com.peopleconnect.CollaborationBackend.model.Forum;

public interface ForumDao {

	public boolean addForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public boolean updateForum(Forum forum);
    public Forum getForum(int forumid);
    public List<Forum> listForums();
    
    public boolean approveForum(Forum forum);
    public boolean rejectForum(Forum forum);
}