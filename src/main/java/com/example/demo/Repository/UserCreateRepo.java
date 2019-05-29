package com.example.demo.Repository;

import com.example.demo.Model.Person;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository

public class UserCreateRepo {
    @Autowired
    JdbcTemplate template;

    //SQL statement to create a new user in the Person table - Khoi, Niki
    public Person createUserWindow(Person person) {
        String sql = "INSERT INTO person (personUsername, personPassword, email, picture, personDescription, " +
                "permission)" +
                "VALUES(?, ?, ?, ?, ?, ?)";
        template.update(sql, person.getPersonUsername(), person.getPersonPassword(),
                person.getEmail(), person.getPicture(), person.getPersonDescription(), person.getPermission());
        return null; // The method needs a return statement

    }

}
