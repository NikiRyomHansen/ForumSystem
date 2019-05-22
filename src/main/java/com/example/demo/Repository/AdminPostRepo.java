package com.example.demo.Repository;

import com.example.demo.Model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class AdminPostRepo implements PostAction {
    @Autowired
    JdbcTemplate template;

    //Implementing methods from PostAction interface

    @Override
    public Boolean deletePost() {
        return null;
    }

    @Override
    public Post editPost() {
        return null;
    }

    //Method to create a new post
    @Override //TODO: Figure out why the table and columns are not recognized even though the functionality works
    public Post createPost(Post post, Person person) {
        String sql = "INSERT INTO post (personID, postDate, changedDate, headline, textField)" +
                "VALUES(?, ?, ?, ?, ?)";
        template.update(sql, person.getPersonID(), post.getPostDate(), post.getChangedDate(), post.getHeadline(),
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




