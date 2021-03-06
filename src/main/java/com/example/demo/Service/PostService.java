package com.example.demo.Service;

import com.example.demo.Model.Comments;
import com.example.demo.Model.Post;
import com.example.demo.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> fetchAll() {
        return postRepository.fetchAll();
    }

    // Method to return all comments on a post
    public List<Comments> fetchAllCommentsOnPost(int id) {return postRepository.fetchAllCommentsOnPost(id);}
}

