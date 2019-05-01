package com.peopleconnect.CollaborationBackend.DaoImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.peopleconnect.CollaborationBackend.Dao.BlogCommentDao;
import com.peopleconnect.CollaborationBackend.model.BlogComment;
@Repository
@Transactional
public class BlogCommentDaoImpl implements BlogCommentDao {

	@Autowired
	SessionFactory sessionFactory;

	@Override
	public boolean addBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().save(blogComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public boolean deleteBlogComment(BlogComment blogComment) {
		try
		{
			sessionFactory.getCurrentSession().delete(blogComment);
			return true;
		}
		catch(Exception e)
		{
		return false;
	}
	}
	@Override
	public BlogComment getBlogComment(int commentid) {
		try
		{
			return(BlogComment)sessionFactory.getCurrentSession().createQuery("from BlogComment where commentid="+commentid).uniqueResult();
		}
		catch (Exception e) {
		
		return null;
	}
	}
	@Override
	public List<BlogComment> listBlogComment(int blogid) {
		try
		{
			return sessionFactory.getCurrentSession().createQuery("from BlogComment where blogid="+blogid).list();
		}
		catch (Exception e) {
		return null;
	}
	}

}