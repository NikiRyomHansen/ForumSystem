package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Comments {

    @Id
    //fields
    private int commentID;
    private int postID;
    private int personID;
    private String commentText;
    private List<Likes> commentLikes;
    private List<Dislikes> commentDislikes;

    //Empty Constructor
    public Comments() {
    }

    //Constructor containing all fields
    public Comments(int commentID, int personID, int postID, String commentText, List<Likes> commentLikes, List<Dislikes> commentDislikes) {
        this.commentID = commentID;
        this.personID = personID;
        this.postID = postID;
        this.commentText = commentText;
        this.commentLikes = commentLikes;
        this.commentDislikes = commentDislikes;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public List<Likes> getCommentLikes() {
        return commentLikes;
    }

    public void setCommentLikes(List<Likes> commentLikes) {
        this.commentLikes = commentLikes;
    }

    public List<Dislikes> getCommentDislikes() {
        return commentDislikes;
    }

    public void setCommentdislikes(List<Dislikes> commentDislikes) {
        this.commentDislikes = commentDislikes;
    }
}
