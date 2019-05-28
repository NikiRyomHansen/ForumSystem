package com.example.demo.Repository;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserPostRepo implements PostAction {
    @Autowired
    JdbcTemplate template;

    /*Deletes a post, deletes each child row where postID = ? so there will be no constraints
    concerning foreign keys when deleting the Post*/
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

    //Method to edit a post
    @Override
    public Post editPost(int postID, Post post) {
        String sql = "UPDATE post SET changedDate = NOW(), headline = ?, textField = ? " +
                     "WHERE postID = ?";
        template.update(sql, post.getHeadline(), post.getTextField(), post.getPostID());
        return null;
    }

    //Method to create a new post
    @Override
    public Post createPost(Post post, Person person) {
        String sql = "INSERT INTO post (personID, belongsToGroup, postDate, changedDate, headline, textField)" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        template.update(sql, person.getPersonID(), post.getBelongsToGroup(), post.getPostDate(), post.getChangedDate(), post.getHeadline(),
                post.getTextField());
        return null;
    }

    //Method to view one post by postID
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
