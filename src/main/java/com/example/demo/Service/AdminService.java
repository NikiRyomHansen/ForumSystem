package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.AdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminRepo adminRepo;

    public Post createPost(Post post, Person person) {
        return adminRepo.createPost(post, person);
    }

}
