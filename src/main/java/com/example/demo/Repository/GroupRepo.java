package com.example.demo.Repository;

import com.example.demo.Model.Group;
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
}
