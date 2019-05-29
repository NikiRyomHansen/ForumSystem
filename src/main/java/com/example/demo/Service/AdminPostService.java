package com.example.demo.Service;

import com.example.demo.Model.*;
import com.example.demo.Repository.AdminPostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminPostService {
    @Autowired
    AdminPostRepo adminPostRepo;

    public Boolean deletePost(int postID) {
        return adminPostRepo.deletePost(postID);
    }

    public Post editPost(int postID, Post post) {
        return adminPostRepo.editPost(postID, post);
    }

    public Post createPost(Post post, Person person) {
        return adminPostRepo.createPost(post, person);
    }

    public Post viewOnePost(int postID) {
        return adminPostRepo.viewOnePost(postID);
    }

    public Post readPost() {
        return adminPostRepo.readPost();
    }

    public Likes likePost() {
        return adminPostRepo.likePost();
    }

    public Dislikes dislikePost() {
        return adminPostRepo.dislikePost();
    }

    public Comments commentPost() {
        return adminPostRepo.commentPost();
    }
}

