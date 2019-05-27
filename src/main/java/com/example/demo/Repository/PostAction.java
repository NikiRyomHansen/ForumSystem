package com.example.demo.Repository;

import com.example.demo.Model.*;

//interface
public interface PostAction {

    //Methods to be implemented in AdminRepo and UserRepo
    public Boolean deletePost(int postID);

    public Post editPost(int postID, Post post);

    public Post createPost(Post post, Person person);

    public Post readPost();

    public Likes likePost();

    public Dislikes dislikePost();

    public Comments commentPost();
}
