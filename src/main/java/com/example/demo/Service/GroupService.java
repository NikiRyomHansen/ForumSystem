package com.example.demo.Service;

import com.example.demo.Model.Group;
import com.example.demo.Model.Post;
import com.example.demo.Repository.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupService {
    @Autowired
    GroupRepo groupRepo;

    public GroupService(){
    }

    // Method to fetch all groups from database
    public List<Group> fetchAllGroups() {
        return this.groupRepo.fetchAllGroups();
    }

    // Method to fetch all posts from a specific group
    public List<Post> fetchAllPostsFromGroup() { return this.groupRepo.fetchAllPostsFromGroup();}
}
