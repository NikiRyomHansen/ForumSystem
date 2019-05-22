package com.example.demo.Repository;

import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class UserCreateRepo {
    @Autowired
    JdbcTemplate template;

    //Method to CreateUser
    public User CreateUser(User user){
        String sql = "INSERT INTO person (username, passwordPerson, email)" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        template.update(sql, user.getUsername(), user.getPasswordPerson(), user.getEmail());
        return null;
    }

    public User addAdditionalInfoToUser(User user) {
        String sql = "INSERT INTO person (";
        return null;
    }




}
