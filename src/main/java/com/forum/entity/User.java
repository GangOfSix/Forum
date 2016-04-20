package com.forum.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private int authority;
	private int level;
	
	@OneToMany(mappedBy="user1")
	public Set<Friend> getToBeFriend() {
		return toBeFriend;
	}
	public void setToBeFriend(Set<Friend> toBeFriend) {
		this.toBeFriend = toBeFriend;
	}
	@OneToMany(mappedBy="user2")
	public Set<Friend> getFriends() {
		return friends;
	}
	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}
	private Set<Friend> toBeFriend = new HashSet<>();
	private Set<Friend> friends = new HashSet<>();
	
	private Set<Post> posts = new HashSet<>();
	
	@Column(nullable=true)
	public int getAuthority() {
		return authority;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	private Set<Reply> replies = new HashSet<>();
	private Set<Comment> comments = new HashSet<>();
	
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
	@Column(nullable=true)
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
}
