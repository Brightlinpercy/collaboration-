package com.peopleconnect.CollaborationBackend.Dao;

import com.peopleconnect.CollaborationBackend.model.Friend;

public interface FriendDao {

	public boolean addFriend(Friend friend);
	public boolean deleteFriend(Friend friend);
    
}