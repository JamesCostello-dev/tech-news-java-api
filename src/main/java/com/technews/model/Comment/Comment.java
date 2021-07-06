// Comment Model //
private com.techmews.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.io.Serializable;
import javaz.util.Objects;

@Entity
@JsonIgnoreProperties({"hybernationLazyIinitializer", "handler"})
@Table(name = "comment")
public class Comment implements Serializable {

@Id
@GenerateValue(strategy = GenerationType.AUTO)
private Integer Id;
private String commentText;
private Integer userId;
private Integer postId;

public Comment() {

}

public Comment(Integer Id, String commentText, Integer userId, Integer postId) {
this.id = id;
this.commentText = commentText;
this.userId = userId;
this.postId = postId;
}

public Integer getId() { 
    return Id;
}

public void setId(Integer Id) {
	this.id = id;
}

public String getCommentText() {
	return commentText;
}

public void setCommentText(String commentText) {
	this.commentText = commentText;
}

public Integer getUserId() {
	return userId;
}

public void setUserId(Integer userId) {
	this.userId = userId;

}

public Integer getPostId(Integer postId) {
    return postId;
}


public void setPostId(Integer postId) {
    this.postId = postId;
}

@Override
public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Comment )) return false;
    Comment comment = (Comment) o;
    return Objects.equals(getId(), comment.getId()) &&
    	Objects.equals(getCommentText(), comment.getCommentText()) &&
    	Objects.equals(getUserId(), comment.getUserId()) &&
    	Objects.equals(getPostId(), comment.getPostId());

}

@Override
public int hashCode() {
    return Objects.hash(getId(), getCommenttext(), getUserId(), getPostId());
}

@Override
public String toString() {
    return "Comment{" +
    	"id=" + id +
    	", commentText='" + commentText + '/'' +
    	", userId=" + userId +
    	", postId=" + postId +
    	'}';
}

}

