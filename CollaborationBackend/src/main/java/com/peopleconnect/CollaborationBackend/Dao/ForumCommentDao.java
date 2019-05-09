package com.peopleconnect.CollaborationBackend.Dao;

import java.util.List;

import com.peopleconnect.CollaborationBackend.model.ForumComment;

public interface ForumCommentDao {
	
	public boolean addForumComment(ForumComment forumComment);

	public boolean deleteForumComment(ForumComment forumComment);

	public ForumComment getForumComment(int fcommentid);

	public List<ForumComment> listForumComment(int forumid);
	

}