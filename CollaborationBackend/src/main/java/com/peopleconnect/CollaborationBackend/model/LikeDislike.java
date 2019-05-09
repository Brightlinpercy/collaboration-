package com.peopleconnect.CollaborationBackend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class LikeDislike {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int dummyid;
	
	@Column
	private int likes;
	
	@Column
	private int dislikes;
	
	@ManyToOne
	private Blog blog;

	public int getDummyid() {
		return dummyid;
	}

	public void setDummyid(int dummyid) {
		this.dummyid = dummyid;
	}

	public int getLikes() {
		return likes;
	}

	public void setLikes(int likes) {
		this.likes = likes;
	}

	public int getDislikes() {
		return dislikes;
	}

	public void setDislikes(int dislikes) {
		this.dislikes = dislikes;
	}

	public Blog getBlog() {
		return blog;
	}

	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
