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

    //SQL statement to view a single person by personID from the person table - Niki
    public Person viewOnePerson(int personID) {
        String sql = "SELECT * FROM person WHERE personID = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        Person person = template.queryForObject(sql, rowMapper, personID);
        return person;
    }

    //SQL statement to view a List of Persons from the person table - Niki
    public List<Person> viewListOfPerson() {
        String sql = "SELECT * FROM person";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.query(sql, rowMapper);
    }

}
