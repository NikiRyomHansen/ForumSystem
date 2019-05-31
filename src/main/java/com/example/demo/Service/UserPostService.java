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

    // Calls method createPost from UserPostRepo
    public Post createPost(Post post, Person person) {
        return userPostRepo.createPost(post, person);
    }

    // Calls method deletePost from UserPostRepo
    public Boolean deletePost(int postID) {
        return userPostRepo.deletePost(postID);
    }

    // Calls method viewOnePost from UserPostRepo
    public Post viewOnePost(int postID) {
        return userPostRepo.viewOnePost(postID);
    }

    // Calls method editPost from UserPostRepo
    public Post editPost(int postID, Post post) {
        return userPostRepo.editPost(postID, post);
    }
}
