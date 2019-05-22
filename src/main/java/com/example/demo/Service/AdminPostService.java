package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.AdminPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPostService {
    @Autowired
    AdminPostRepo adminPostRepo;

    public Post createPost(Post post, Person person) {
        return adminPostRepo.createPost(post, person);
    }

}

