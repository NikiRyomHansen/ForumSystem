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

    //Deletes a post TODO: Consider constraints with foreign keys when deleting a post
    @Override
    public Boolean deletePost(int postID) {
        String sql = "DELETE FROM post WHERE postID = ?";
        return template.update(sql, postID) > 0;
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
