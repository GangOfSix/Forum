package com.forum.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="t_user")
@Entity
public class User {
	private int id;
	private String nickname;
	private String password;
	private String email;
	private int phonenumber;
	private String face;
	//private int range;
	private int level;
	/*private User user;
	private Set<User> users = new HashSet<>();*/
	private Set<Post> posts = new HashSet<>();
	private Set<Reply> replies = new HashSet<>();
	private Set<Comment> comments = new HashSet<>();
	
	/*public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}*/
	
	@OneToMany(mappedBy="user")
	public Set<Post> getPosts() {
		return posts;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	@OneToMany(mappedBy="user")
	public Set<Reply> getReplies() {
		return replies;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	@OneToMany(mappedBy="user")
	public Set<Comment> getComments() {
		return comments;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(nullable=true)
	public int getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(int phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getFace() {
		return face;
	}
	public void setFace(String face) {
		this.face = face;
	}
/*	@Column(nullable=true)
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}*/
	@Column(nullable=true)
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
