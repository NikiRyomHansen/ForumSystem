package com.example.demo.Repository;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserPostRepo implements PostAction {
    @Autowired
    JdbcTemplate template;

    @Override
    public Boolean deletePost() {
        return null;
    }

    @Override
    public Post editPost() {
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
