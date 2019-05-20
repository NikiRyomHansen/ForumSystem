package com.example.demo.Repository;

import com.example.demo.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PostRepository {
    @Autowired
    JdbcTemplate template;

    //method to instantiate a list of posts
    public List<Post> fetchAll() {
        String sql = "SELECT * FROM post";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return template.query(sql, rowMapper);
    }

}
