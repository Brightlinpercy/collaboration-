package com.peopleconnect.CollaborationBackend.Dao;

import com.peopleconnect.CollaborationBackend.model.User;

public interface UserDao {
	
	public boolean registerUser(User user);
	public boolean updateUser(User user);
	public User checkUser(User user);
	public User getUser(String emailid);

}