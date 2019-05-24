package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Comments {

    @Id
    //fields
    private int commentID;
    private int personID;
    private int belongsToPost;
    private String commentText;
    private List<Likes> commentLikes;
    private List<Dislikes> commentdislikes;
    private Person person;

    //Empty Constructor
    public Comments() {
    }

    //Constructor containing all fields
    public Comments(int commentID, int personID, int belongsToPost, String commentText, List<Likes> commentLikes, List<Dislikes> commentdislikes, Person person) {
        this.commentID = commentID;
        this.personID = personID;
        this.belongsToPost = belongsToPost;
        this.commentText = commentText;
        this.commentLikes = commentLikes;
        this.commentdislikes = commentdislikes;
        this.person = person;
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

    public int getBelongsToPost() {
        return belongsToPost;
    }

    public void setBelongsToPost(int belongsToPost) {
        this.belongsToPost = belongsToPost;
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

    public List<Dislikes> getCommentdislikes() {
        return commentdislikes;
    }

    public void setCommentdislikes(List<Dislikes> commentdislikes) {
        this.commentdislikes = commentdislikes;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
