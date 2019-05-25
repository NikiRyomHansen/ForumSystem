package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Repository.UserUpdateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserUpdateService {
    @Autowired
    UserUpdateRepo userUpdateRepo;

    public Person updatePerson(int personID, Person person) {
        return userUpdateRepo.updatePerson(personID, person);
    }
}
