package com.example.demo.Repository;

import com.example.demo.Model.Person;
import com.example.demo.Model.PrivateMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class UserMessageRepo {
    @Autowired
    JdbcTemplate template;

    //Method to get all private messages
    public List<PrivateMessage> getALlPrivateMessages(){
        String sql = "SELECT * FROM private_messages";
        RowMapper<PrivateMessage> rowMapper = new BeanPropertyRowMapper<>(PrivateMessage.class);

        return template.query(sql, rowMapper);
    }

    // Method to read a message
    public PrivateMessage readPrivateMessage(int privateMessageID, Person person){
        String sql = "SELECT * FROM private_message WHERE privateMessageID = ?";
        RowMapper<PrivateMessage> rowMapper = new BeanPropertyRowMapper<>(PrivateMessage.class);
        // makes the message readed
        PrivateMessage privateMessage = template.queryForObject(sql, rowMapper, privateMessageID);
        sql = "UPDATE privateMessage SET isRead = 1 WHERE privateMessageID = ?";
        template.update(sql, person.getPersonID());

        return privateMessage;
    }

    // Method to send a message
    public PrivateMessage  sendPrivateMessage(Person toUserID, Person fromUserID, PrivateMessage message){
        String sql = "INSERT INTO private_messages (toUserID, fromUserID, headline, message, timestampPrivateMessage, isRead " +
                "VALUES (?,?,?,?,?,?))";
        template.update(sql,toUserID.getPersonID(), fromUserID.getPersonID(), message.getHeadline(), message.getMessage(), message.getTimestampPrivateMessage(), message.isRead());

        return null;
    }

    //Method to delete message
    public Boolean deletePrivateMessage(int privateMessageID){
        String sql = "DELETE FROM private_messages WHERE id = ?";

        return template.update(sql, privateMessageID) >0;
    }

    //Method to reply to message
    public PrivateMessage replyToPrivateMessage(){

        return null;
    }



}
