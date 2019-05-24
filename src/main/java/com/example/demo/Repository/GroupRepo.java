package com.example.demo.Repository;

import com.example.demo.Model.Group;
import com.example.demo.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupRepo {
    @Autowired
    JdbcTemplate template;

    public GroupRepo() {
    }

    public List<Group> fetchAllGroups() {
        String sql = "SELECT * FROM forum_groups";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        return template.query(sql, rowMapper);
    }

    public List<Post> fetchAllPostsFromGroup() {
        String sql = "SELECT * FROM post WHERE belongsToGroup = 1";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return template.query(sql, rowMapper);
    }
}
