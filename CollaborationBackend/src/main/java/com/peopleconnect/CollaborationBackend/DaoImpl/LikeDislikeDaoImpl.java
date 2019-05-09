package com.peopleconnect.CollaborationBackend.DaoImpl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.peopleconnect.CollaborationBackend.Dao.LikeDislikeDao;
import com.peopleconnect.CollaborationBackend.model.LikeDislike;

@Repository
@Transactional
public class LikeDislikeDaoImpl implements LikeDislikeDao {
@Autowired
SessionFactory sessionFactory;
	@Override
	public boolean updateLikeDislike(LikeDislike likedislike) {try {
		
		sessionFactory.getCurrentSession().saveOrUpdate(likedislike);
		return true;
	} catch (Exception e) {
	
		return false;
	
	}

	}

	@Override
	public LikeDislike selectLikeDislike(int blogId) {
		try {
			return (LikeDislike) sessionFactory.getCurrentSession().createQuery("from LikeDislike where blogid=" + blogId).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}

