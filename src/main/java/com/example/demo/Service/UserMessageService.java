package com.example.demo.Service;

import com.example.demo.Model.PrivateMessage;
import com.example.demo.Repository.UserMessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserMessageService {
    @Autowired
    UserMessageRepo userMessageRepo;

    // Service Method to Show all messages
    public List<PrivateMessage> getAllPrivateMessages(int personID){
        return this.userMessageRepo.getAllPrivateMessages(personID);
    }





}
