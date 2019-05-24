package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.UserViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserViewService {
    @Autowired
    UserViewRepo userViewRepo;

    public Person viewOnePerson(int personID) {
        return userViewRepo.viewOnePerson(personID);
    }

    public List<Person> viewListOfPerson() {
        return userViewRepo.viewListOfPerson();
    }

    public Person viewPersonIDOne(int personID) {
        return userViewRepo.viewPersonIDOne(personID);
    }
}
