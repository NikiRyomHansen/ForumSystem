package com.example.demo.Service;

import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.UserGroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupService {
    @Autowired
    UserGroupRepo userGroupRepo;

    public UserGroupService(){
    }

    // Method to fetch all groups from database
    public List<Group> retrieveAllGroups() {

        return this.userGroupRepo.retrieveAllGroups();
    }

    // Method to fetch all posts from a specific group
    public List<Post> viewGroup(Group group) {

        return this.userGroupRepo.viewGroup(group);
    }

    // Method to join a Group
    public boolean joinGroup(Group group, Person person) {

        return this.userGroupRepo.joinGroup(group, person);
    }

    // Method to leave a Group
    public boolean leaveGroup(Group group, Person person) {
        return this.userGroupRepo.leaveGroup(group, person);
    }

    // (postToGroup)

    // Method to create a new Group
    public boolean createGroup(Group group, Person person) {
        return this.userGroupRepo.createGroup(group, person);
    }

    // (deleteGroup)
    public boolean deleteGroup(int groupID) { return this.userGroupRepo.deleteGroup(groupID); }

}
