package com.example.demo.Repository;

import com.example.demo.Model.PrivateMessage;
import com.example.demo.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository

public class UserMessageRepo {
    @Autowired
    JdbcTemplate template;


    // Method to read a message
    public PrivateMessage readPrivateMessage(){


        return null;
    }

    // Method to send a message
    public PrivateMessage  sendPrivateMessage(User toUserID, User FromUserID){

        return null;
    }

    //Method to delete message
    public Boolean deletePrivateMessage(){

        return null;
    }

    //Method to reply to message
    public PrivateMessage replyToPrivateMessage(){

        return null;
    }



}
