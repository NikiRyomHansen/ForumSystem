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

    //Method to get all private messages and senders name
    public List<PrivateMessage> getAllPrivateMessages(int personID){
        // beneath is there statement to make a join between the person table and the private_messages table
        String sql = "SELECT person.personUsername, fromUserID, headline,\n" +
                "\ttimestampPrivateMessage FROM private_messages\n" +
                "\tFULL JOIN  person ON  fromUserID = personID  \n" +
                "    WHERE toUserID = " + personID +
                "\tORDER BY timestampPrivateMessage";
        RowMapper<PrivateMessage> rowMapper = new BeanPropertyRowMapper<>(PrivateMessage.class);
        List<PrivateMessage> privateMessagesList = template.query(sql, rowMapper);
        return privateMessagesList;
    }

    // Method to read a message where it use a parameter privateMessage ID
    public PrivateMessage readPrivateMessage(int privateMessageID){
        String sql = "SELECT * FROM private_message WHERE privateMessageID = ?";
        RowMapper<PrivateMessage> rowMapper = new BeanPropertyRowMapper<>(PrivateMessage.class);
        PrivateMessage privateMessage = template.queryForObject(sql, rowMapper, privateMessageID);
        return privateMessage;
    }

    //Find person by name
    public Person findPersonByUsername(){

        return null;
    }

    // Method to send a message
    public PrivateMessage  sendPrivateMessage(Person toUser, Person fromUser, PrivateMessage message){
        String sql = "INSERT INTO private_messages (toUserID, fromUserID, headline, message, timestampPrivateMessage, isRead " +
                "VALUES (?,?,?,?,?,?))";
        template.update(sql,toUser.getPersonID(), fromUser.getPersonID(), message.getHeadline(), message.getMessage(), message.getTimestampPrivateMessage(), message.isRead());

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
