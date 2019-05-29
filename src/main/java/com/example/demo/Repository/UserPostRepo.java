package com.example.demo.Repository;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

/*
This class contains all the SQL statements related to User actions performed on Post related tables
in our database.
 */

@Repository //Uses the PostAction interface
public class UserPostRepo implements PostAction {
    @Autowired
    JdbcTemplate template;

    /*Deletes a post, deletes each child row where postID = ? so there will be no constraints
    concerning foreign keys when deleting the Post - Niki, Rasmus*/
    @Override
    public Boolean deletePost(int postID) {
        String sqlDislikes = "DELETE FROM dislikes WHERE postID = ?";
        String sqlLikes = "DELETE FROM likes WHERE postID = ?";
        String sqlPostViews = "DELETE FROM post_views WHERE postID = ?";
        String sqlComments = "DELETE FROM comments WHERE postID = ?";
        String sqlPost = "DELETE FROM post WHERE postID = ?";
        template.update(sqlDislikes, postID);
        template.update(sqlLikes, postID);
        template.update(sqlPostViews, postID);
        template.update(sqlComments, postID);
        return template.update(sqlPost, postID) > 0;
    }

    //SQL statement to edit a post - Niki
    @Override
    public Post editPost(int postID, Post post) {
        String sql = "UPDATE post SET changedDate = NOW(), headline = ?, textField = ? " +
                     "WHERE postID = ?";
        template.update(sql, post.getHeadline(), post.getTextField(), post.getPostID());
        return null;
    }

    //SQL statement to create a new post - Niki
    @Override
    public Post createPost(Post post, Person person) {
        String sql = "INSERT INTO post (personID, groupID, postDate, changedDate, headline, textField)" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        template.update(sql, person.getPersonID(), post.getGroupID(), post.getPostDate(), post.getChangedDate(), post.getHeadline(),
                post.getTextField());
        return null;
    }

    //SQL statement to view a single post by postID - Niki
    @Override
    public Post viewOnePost(int postID) {
        String sql = "SELECT * FROM post WHERE postID = ?";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        Post post = template.queryForObject(sql, rowMapper, postID);
        return post;
    }

    @Override
    public Post readPost() {
        return null;
    }

    @Override
    public Likes likePost() {
        return null;
    }

    @Override
    public Dislikes dislikePost() {
        return null;
    }

    @Override
    public Comments commentPost() {
        return null;
    }
}
