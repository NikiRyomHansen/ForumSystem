package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Post {

    @Id
    //fields
    //formatting for Date
    java.util.Date dt = new java.util.Date();
    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private int postID;
    private int belongsToGroup;
    private int personID;
    private String postDate = sdf.format(dt);
    private String changedDate = sdf.format(dt);
    private String headline;
    private String textField;
    private List<Comments> comments;
    private List<Views> views;
    private List<Likes> likes;
    private List<Dislikes> dislikes;

    //Empty Constructor
    public Post() {
    }

    //Constructor containing all fields
    public Post(int postID, int belongsToGroup, String postDate, String changedDate, String headline, String textField,
                List<Comments> comments, List<Views> views, List<Likes> likes, List<Dislikes> dislikes) {
        this.postID = postID;
        this.belongsToGroup = belongsToGroup;
        this.postDate = postDate;
        this.changedDate = changedDate;
        this.headline = headline;
        this.textField = textField;
        this.comments = comments;
        this.views = views;
        this.likes = likes;
        this.dislikes = dislikes;
    }


    // Accesors and Mutators
    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

    public int getBelongsToGroup() {
        return belongsToGroup;
    }

    public void setBelongsToGroup(int belongsToGroup) {
        this.belongsToGroup = belongsToGroup;
    }

    public int getPersonID() {
        return personID;
    }

    public void setPersonID(int personID) {
        this.personID = personID;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(String changedDate) {
        this.changedDate = changedDate;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getTextField() {
        return textField;
    }

    public void setTextField(String textField) {
        this.textField = textField;
    }

    public List<Comments> getComments() {
        return comments;
    }

    public void setComments(List<Comments> comments) {
        this.comments = comments;
    }

    public List<Views> getViews() {
        return views;
    }

    public void setViews(List<Views> views) {
        this.views = views;
    }

    public List<Likes> getLikes() {
        return likes;
    }

    public void setLikes(List<Likes> likes) {
        this.likes = likes;
    }

    public List<Dislikes> getDislikes() {
        return dislikes;
    }

    public void setDislikes(List<Dislikes> dislikes) {
        this.dislikes = dislikes;
    }


}
