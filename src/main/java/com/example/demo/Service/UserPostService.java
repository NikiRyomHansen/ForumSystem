package com.example.demo.Service;

import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.UserPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserPostService {
    @Autowired
    UserPostRepo userPostRepo;

    public Post createPost(Post post, Person person) {
        return userPostRepo.createPost(post, person);
    }

    public Boolean deletePost(int postID) {
        return userPostRepo.deletePost(postID);
    }

    public Post viewOnePost(int postID) {
        return userPostRepo.viewOnePost(postID);
    }

    public Post editPost(int postID, Post post) {
        return userPostRepo.editPost(postID, post);
    }
}
