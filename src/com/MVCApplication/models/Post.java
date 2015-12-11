package com.MVCApplication.models;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="POSTS")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@NamedQuery(name="Posts.byCreator", query="from Post where creator = :name")
public class Post {
	@Id @GeneratedValue
	@Column(name="POST_ID")
	private int postId;
	@ManyToOne
	@JoinColumn(name="POST_CREATOR")
	private User creator;
	@Column(name="POST_TITLE")
	private String title;
	@Column(name="POST_TEXT")
	private String text;
	@ElementCollection
	@JoinTable(name="POSTS_MODIFIERS")
	private Map<User,Date> modifiers = new LinkedHashMap<User,Date>();
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Map<User,Date> getModifiers() {
		return modifiers;
	}
	public void setModifiers(Map<User,Date> modifiers) {
		this.modifiers = modifiers;
	}
}
