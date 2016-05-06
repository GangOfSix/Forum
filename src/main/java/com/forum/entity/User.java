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
	private int authority;
	private String captcha;//验证码
	private Set<Comment> comments = new HashSet<>();
	private String email;
	private String face;
	private Set<Friend> friends = new HashSet<>();
	private int id;
	private int level;
	private String nickname;
	private String password;
	
	private long phonenumber;
	private Set<Post> posts = new HashSet<>();
	private Set<Reply> replies = new HashSet<>();
	private boolean status;//状态
	private Set<Friend> toBeFriend = new HashSet<>();
	@Column(nullable=true)
	public int getAuthority() {
		return authority;
	}
	
	public String getCaptcha() {
		return captcha;
	}
	
	@OneToMany(mappedBy="user")
	public Set<Comment> getComments() {
		return comments;
	}
	public String getEmail() {
		return email;
	}
	public String getFace() {
		return face;
	}
	@OneToMany(mappedBy="user2")
	public Set<Friend> getFriends() {
		return friends;
	}
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	@Column(nullable=true)
	public int getLevel() {
		return level;
	}
	public String getNickname() {
		return nickname;
	}
	public String getPassword() {
		return password;
	}
	@Column(nullable=true)
	public long getPhonenumber() {
		return phonenumber;
	}
	@OneToMany(mappedBy="user")
	public Set<Post> getPosts() {
		return posts;
	}
	@OneToMany(mappedBy="user")
	public Set<Reply> getReplies() {
		return replies;
	}
	@OneToMany(mappedBy="user1")
	public Set<Friend> getToBeFriend() {
		return toBeFriend;
	}
	public boolean isStatus() {
		return status;
	}
	public void setAuthority(int authority) {
		this.authority = authority;
	}
	public void setCaptcha(String captcha) {
		this.captcha = captcha;
	}
	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFace(String face) {
		this.face = face;
	}
	public void setFriends(Set<Friend> friends) {
		this.friends = friends;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setPhonenumber(long phonenumber) {
		this.phonenumber = phonenumber;
	}
	public void setPosts(Set<Post> posts) {
		this.posts = posts;
	}
	public void setReplies(Set<Reply> replies) {
		this.replies = replies;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public void setToBeFriend(Set<Friend> toBeFriend) {
		this.toBeFriend = toBeFriend;
	}
	
}
