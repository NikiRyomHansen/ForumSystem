package com.example.demo.Service;


import com.example.demo.Model.Person;
import com.example.demo.Repository.UserCreateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCreateService {
    @Autowired
    UserCreateRepo userCreateRepo;

    //Calls the method from UserCreateRepo
    public Person createUserWindow(Person person){
        return userCreateRepo.createUserWindow(person);

    }

}
