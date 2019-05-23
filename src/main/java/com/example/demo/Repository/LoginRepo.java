package com.example.demo.Repository;

import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository

public class LoginRepo {
    @Autowired
    JdbcTemplate template;

    /*TODO: We will take this, when we have added more functionality
    //method to login - Rasmus
    public Person login(Person person) {
        String sql = "SELECT * FROM person " +
                "WHERE personUsername = ?" +
                "AND personPassword = ?";
        RowMapper<Person> rowMapper = new BeanPropertyRowMapper<>(Person.class);
        return template.queryForObject(sql, rowMapper);
        // If there is something in the result set, proceed to login

        // Else if there is nothing in the result set, return error.
    }*/
}
