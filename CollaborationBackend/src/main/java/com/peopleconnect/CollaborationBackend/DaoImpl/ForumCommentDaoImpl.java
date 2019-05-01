package com.peopleconnect.CollaborationBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peopleconnect.CollaborationBackend.Dao.ForumCommentDao;
import com.peopleconnect.CollaborationBackend.model.ForumComment;
@Repository
@Transactional
public class ForumCommentDaoImpl implements ForumCommentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addForumComment(ForumComment forumComment)  {
		try
		{
			sessionFactory.getCurrentSession().save(forumComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean deleteForumComment(ForumComment forumComment){
		try
		{
			sessionFactory.getCurrentSession().delete(forumComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}

	@Override
	public ForumComment getForumComment(int fcommentid) {
		try
		{
			return(ForumComment)sessionFactory.getCurrentSession().createQuery("from ForumComment where fcommentid="+fcommentid).uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}
	@Override
	public List<ForumComment> listForumComment(int forumid) {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from ForumComment").list();
		}
		catch (Exception e) {
		return null;
	}
	}

}