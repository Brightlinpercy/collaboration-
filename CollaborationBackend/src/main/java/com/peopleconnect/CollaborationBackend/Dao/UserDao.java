package com.peopleconnect.CollaborationBackend.Dao;

import java.util.List;

import com.peopleconnect.CollaborationBackend.model.UserDetail;

public interface UserDao {
	
	public boolean registerUser(UserDetail user);
	public boolean updateUser(UserDetail user);
	public UserDetail checkUser(UserDetail user);
	public UserDetail getUser(int userid);
	UserDetail getUserByEmail(String emailid);
	boolean makeOffline(UserDetail user);
	boolean makeOnline(UserDetail user);
	List<UserDetail>selectAllUsers();
}