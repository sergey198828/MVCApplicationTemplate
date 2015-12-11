package com.MVCApplication.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Sergey
 *
 */
@Entity
@Table(name="USERS")
public class User implements Comparable<User>{
@Id
@Column(name="USERS_USER_NAME")
String userName;

@Column(name="USERS_USER_PASSWORD_HASH")
int passwordHash;

@Embedded
Credentials credentials;

@ElementCollection
@JoinTable(name="USERS_ADDRESS")
private List<Address> addresses = new ArrayList<Address>();

@ElementCollection
@JoinTable(name="USERS_FRIENDS")
private Set<User> friends = new TreeSet<User>();

@OneToMany(cascade=CascadeType.ALL)
private List<Post> posts = new ArrayList<Post>();

public List<Post> getPosts() {
	return posts;
}

public void setPosts(List<Post> posts) {
	this.posts = posts;
}

public String getUserName(){
return userName;
}

public void setUserName(String userName){
this.userName=userName;
}

public int getPasswordHash(){
return passwordHash;
}

public void setPasswordHash(int passwordHash){
this.passwordHash=passwordHash;
}

public Credentials getCredentials(){
return credentials;
}

public void setCredentials(Credentials credentials){
this.credentials=credentials;
}

public List<Address>getAddresses(){
return addresses;
}

public void setAddresses(List<Address> addresses){
this.addresses=addresses;
}

public Set<User> getFriends(){
return friends;
}

public void setFriends(Set<User> friends){
this.friends=friends;
}

@Override
public int compareTo(User arg0) {
	return this.toString().compareTo(arg0.toString());
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	User other = (User) obj;
	if (addresses == null) {
		if (other.addresses != null)
			return false;
	} else if (!addresses.equals(other.addresses))
		return false;
	if (credentials == null) {
		if (other.credentials != null)
			return false;
	} else if (!credentials.equals(other.credentials))
		return false;
	if (friends == null) {
		if (other.friends != null)
			return false;
	} else if (!friends.equals(other.friends))
		return false;
	if (passwordHash != other.passwordHash)
		return false;
	if (posts == null) {
		if (other.posts != null)
			return false;
	} else if (!posts.equals(other.posts))
		return false;
	if (userName == null) {
		if (other.userName != null)
			return false;
	} else if (!userName.equals(other.userName))
		return false;
	return true;
}

@Override
public String toString(){
	return this.userName;
}
}
