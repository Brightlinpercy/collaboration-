package com.peopleconnect.CollaborationBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peopleconnect.CollaborationBackend.Dao.UserDao;
import com.peopleconnect.CollaborationBackend.model.UserDetail;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean registerUser(UserDetail user) {
		try
		{
			user.setIsonline("false");
			user.setStatus("offline");
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public boolean updateUser(UserDetail user){
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
	public UserDetail checkUser(UserDetail user) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public UserDetail getUser(int userid)
	{
		try
		{
			return(UserDetail)sessionFactory.getCurrentSession().createQuery("from UserDetail where userid="+userid).uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}
	public UserDetail getUserByEmail(String emailid) {
		
		try
		{
			return (UserDetail)sessionFactory.getCurrentSession().createQuery("from UserDetail where emailid='"+emailid+"'").uniqueResult();
			
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			return null;
		}
		
	}
	public boolean makeOffline(UserDetail user) {
		
		user.setIsonline("false");
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch (Exception e) {
			
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean makeOnline(UserDetail user) {
		
		user.setIsonline("true");
		try
		{
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch (Exception e) {
	
			System.out.println(e.getMessage());
			return false;
		}
	}
		@Override
	public List<UserDetail> selectAllUsers()  {
		// TODO Auto-generated method stub
		try {
			return sessionFactory.getCurrentSession().createQuery("from UserDetail").list();

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

}


