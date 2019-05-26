package com.example.demo.Repository;

import com.example.demo.Model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserUpdateRepo {
    @Autowired
    JdbcTemplate template;

    //SQL Statement to update a Person in the person table using personID - Niki
    public Person updatePerson(int personID, Person person) {
        String sql = "UPDATE person SET personUsername = ?, email = ?, personDescription = ?" +
                "     WHERE personID = ?";
        template.update(sql, person.getPersonUsername(), person.getEmail(),
                person.getPersonDescription(), person.getPersonID());
        return null;
    }

    //SQL statement to delete a Person from the person table (make sure to have a confirmation box for the user)


}
