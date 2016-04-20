package com.forum.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="t_comment")
@Entity
public class Comment {
	private int id;
	private String context;
	private User user;
	private Set<Reply> repies = new HashSet<>();
	private Post post;
	@ManyToOne
	@JoinColumn(name="postid")
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@ManyToOne
	@JoinColumn(name="userid")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@OneToMany(mappedBy="comment")
	public Set<Reply> getRepies() {
		return repies;
	}
	public void setRepies(Set<Reply> repies) {
		this.repies = repies;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}
