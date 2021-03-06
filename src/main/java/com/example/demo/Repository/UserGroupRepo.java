package com.example.demo.Repository;

import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/* This class contains all the SQL statements related to User actions performed on Group related tables
in our database.

@Author: Rasmus Knoth Nielsen
 */

@Repository
public class UserGroupRepo implements GroupAction{

    // Connecting UserGroup Repo with Jdbc Template.
    // It is required by Spring.
    @Autowired
    JdbcTemplate template;

    // Default constructor, required by Spring.
    public UserGroupRepo() {
    }

    // Method to retrieve all groups on forum to display them in the groups.html page
    @Override
    public List<Group> retrieveAllGroups() {
        String sql = "SELECT * FROM forum_groups";
        RowMapper<Group> rowMapper = new BeanPropertyRowMapper<>(Group.class);
        return template.query(sql, rowMapper);
    }

    // Method to retrieve all posts from a group and display them in the groupPosts.html page
    @Override
    public List<Post> viewGroup(Group group) {
        String sql = "SELECT * FROM post WHERE belongsToGroup = " + group.getGroupID();
        RowMapper<Post> rowMapper = new BeanPropertyRowMapper<>(Post.class);
        return template.query(sql, rowMapper);
    }

    // Method to join a specific group (Rasmus)
    @Override
    public boolean joinGroup(int groupID, Person person) {
        try {

            String sql = "INSERT INTO group_members( groupID, userID, permission, memberSince)" +
                    "VALUES( ?, ?, ?, NOW())";
            template.update(sql, groupID, person.getPersonID(), person.getPermission());
            return true;

        } catch (Exception ex) {
            return false;
        }

    }

    // Method to leave a specific group (Rasmus)
    @Override
    public boolean leaveGroup(Group group, Person person) {
        try {
            String sql = "DELETE FROM group_members WHERE groupID = ? AND userID = ?";
            template.update(sql, group.getGroupID(), person.getPersonID());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Method to make a post to a specific Group
    @Override
    public boolean postToGroup(Group group, Person person) { return true;}

    // Method to create a new Group (Rasmus)
    @Override
    public boolean createGroup(Group group, Person person) {
        try {
            String sql = "INSERT INTO forum_groups(groupName, groupDescription)" +
                    "VALUES(?, ?)";
            template.update(sql, group.getGroupName(), group.getGroupDescription());
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    // Method to delete a specific Group (Rasmus)
    @Override
    public boolean deleteGroup(int groupID) {
        try {
            String sql = "DELETE FROM forum_groups WHERE groupID = ?";
            template.update(sql, groupID);
            return true;
        } catch (Exception ex) {
            return false;
        }

    }

}
