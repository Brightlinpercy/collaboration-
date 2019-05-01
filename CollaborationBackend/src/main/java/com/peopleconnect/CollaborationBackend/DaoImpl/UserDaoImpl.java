package com.peopleconnect.CollaborationBackend.DaoImpl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peopleconnect.CollaborationBackend.Dao.UserDao;
import com.peopleconnect.CollaborationBackend.model.User;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(User user) {
		try
		{
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateUser(User user){
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}


	@Override
	public User checkUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User getUser(String emailid)
	{
		try
		{
			return(User)sessionFactory.getCurrentSession().createQuery("from User where emailid='"+emailid+"'").uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}
}