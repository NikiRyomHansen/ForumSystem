package com.example.demo.Repository;

import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserGroupRepo implements GroupAction{
    @Autowired
    JdbcTemplate template;

    public UserGroupRepo() {
    }

    @Override
    public List<Group> retrieveAllGroups() {
        String sql = "SELECT * FROM forum_groups";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public List<Post> viewGroup() {
        String sql = "SELECT * FROM post WHERE belongsToGroup = 1";
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return template.query(sql, rowMapper);
    }

    @Override
    public boolean joinGroup(Group group, Person person) {
        try {

            String sql = "INSERT INTO group_members( groupID, userID, permission, memberSince)" +
                    "VALUES( ?, ?, ?, NOW())";
            // Variable to contain current time for timestamp
            template.update(sql, group.getGroupID(), person.getPersonID(), person.getPermission());
            return true;

        } catch (Exception ex) {
            return false;
        }

    }


    @Override
    public boolean leaveGroup() { return true;}

    @Override
    public boolean postToGroup() { return true;}

    @Override
    public boolean deleteGroup() { return true;}

}
