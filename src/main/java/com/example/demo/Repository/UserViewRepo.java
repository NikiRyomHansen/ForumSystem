package com.example.demo.Repository;

import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserViewRepo {
    @Autowired
    JdbcTemplate template;

    //Method to view one person by personID from the person table
    public Person viewOnePerson(int personID) {
        String sql = "SELECT * FROM person WHERE personID = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person person = template.queryForObject(sql, rowMapper, personID);
        return person;
    }

    //Method to view a List of Persons from the person table
    public List<Person> viewListOfPerson() {
        String sql = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }


    // This is not currently implemented in the controller
    //Method to view one personUsername from the person table
    public Person viewPersonIDOne(int personID) {
        String sql = "SELECT * FROM person WHERE personID = 1";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person person = template.queryForObject(sql, rowMapper, personID);
        return person;
    }

}
