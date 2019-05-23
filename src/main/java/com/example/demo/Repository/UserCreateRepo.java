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

    //Method to CreateUser
    public User createUserWindow(Person person) {
        String sql = "INSERT INTO person (personUsername, personPassword, email, permission)" +
                "VALUES(?, ?, ?, ?)";
        template.update(sql, person.getPersonUsername(), person.getPersonPassword(),
                person.getEmail(), person.getPermission());
        return null; // The method needs a return statement

    }

    public Person login(Person person) {
        String sql = "SELECT * FROM person " +
                "WHERE personUsername = ?" +
                "AND personPassword = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.queryForObject(sql, rowMapper);
        // If there is something in the result set, proceed to login

        // Else if there is nothing in the result set, return error.
    }


    //Method to CreateUser - Niki, Khoi
    public User createUser(User user){
        String sql = "INSERT INTO person (username, passwordPerson, email)" +
                "VALUES(?, ?, ?)";
        template.update(sql, user.getPersonUsername(), user.getPersonPassword(), user.getEmail());
        return null;
    }

    //Method to insert picture and description to additional profile info page - Niki
    public User addAdditionalInfoToUser(User user) {
        String sql = "INSERT INTO person (picture, personDescription)" +
                "VALUES(?, ?)";
        template.update(sql, user.getPicture(), user.getPersonDescription());
        return null;
    }




}
