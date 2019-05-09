package com.peopleconnect.CollaborationBackend.Dao;

import com.peopleconnect.CollaborationBackend.model.LikeDislike;

public interface LikeDislikeDao {

	 public boolean updateLikeDislike(LikeDislike likedislike);
	    public LikeDislike selectLikeDislike(int blogId);
	
}
