package com.peopleconnect.CollaborationBackend.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;

@Entity
public class BlogComment {
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private int commentid;
    @Column
    private int blogid;
    @Column
    private String commentdata;
    @Column
    Date createDate;
    @ManyToOne
    private User useremailid;
    
	public int getCommentid() {
		return commentid;
	}

	public void setCommentid(int commentid) {
		this.commentid = commentid;
	}

	public int getBlogid() {
		return blogid;
	}

	public void setBlogid(int blogid) {
		this.blogid = blogid;
	}

	public String getCommenttext() {
		return commentdata;
	}

	public void setCommenttext(String commenttext) {
		this.commentdata = commenttext;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



}
