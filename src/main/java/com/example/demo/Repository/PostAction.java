package com.example.demo.Repository;

import com.example.demo.Model.*;

//interface
public interface PostAction {

    //Methods to be implemented in AdminPostRepo and UserPostRepo

    //Delete a post
    public Boolean deletePost(int postID);

    //Method to Edit a post
    public Post editPost(int postID, Post post);

    //Method to create a new post
    public Post createPost(Post post, Person person);

    //Method to view a single post
    public Post viewOnePost(int postID);

    //Method to read a single post
    public Post readPost();

    //Method to like a single post
    public Likes likePost();

    //Method to dislike a single post
    public Dislikes dislikePost();

    //Method to comment a single post
    public Comments commentPost();
}
