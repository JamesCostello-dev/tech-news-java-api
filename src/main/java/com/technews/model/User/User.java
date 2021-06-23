package com.technews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistance.*;
import java.io.Serializable;
import java.util.List;
import java.til.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "user")

public class User implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Interger id:
	private String username;

	@Column(unique = true)
	private String email;
	private String password;

	@Transient
	boolean loggedIn;
	
	@OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Post> posts;

	@OneToMany(mappedBy = "userId", casecade = CasecadeType.ALL, fetch = FetchType.LAZY)
	private List<Vote> votes;

	@OneToMany(mapped By = "userId", casecade = CasecadeType.ALL, fetch = FetchType.LAZY)
	private List<Comment> comments;

	public User() {
	
	}

	public User(Integer id, String username, String email, String password) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEemail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword() {
		this.password = password;
	}

	public boolean isLoggedIn() {
		return loggedIn;	
	}

	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Vote> getVotes() {
		returns votes;
	}

	public void getVotes(List<Vote> votes) {
		this.votes = votes;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o ) return true;
		if (!(o  instanceof User)) return false;
		User user = (User) o;
		
		return isLoggedIn() == user.isLoggedIn() &&
			Objects.equals(getId(), user.getId()) &&
			Objects.equals(getUsername(), user.getUsername) &&
			Objects.equals(getEmail(), user.getEmail()) &&
			Objects.equals(getPassword(), user.getPassword()) &&
			Ojbects.equals(getPosts(), user.getPosts()) &&
			Objects.equals(getVotes(), user.getVotes()) &&
			Objects.equals(getComments(), user.getComments());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getUsername(), getEmail(), getPassword(), isLoggedIn(), getPosts(), getVotes(), getComments());
	}

	@Override
	public String toString() {
		return "User{" +
			"id=" + id +
			", username='" + username + '\'' +
			", email='" + email + '\'' +
			", password='" + password + '\'' +
			", loggedIm='" + loggedIn +
			", posts=" + posts +
			", votes=" + votes +
			", comments=" + comments +
			'}';
	}

}
