package com.example.demo.Controller;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.AdminRepo;
import com.example.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminHomeController {
    @Autowired
    PostService postService;
    @Autowired
    AdminRepo adminRepo;

    //Request a GetMapping to the front page showing all posts.
    @GetMapping("/")
    public String index(Model model) {
        List<Post> postList = postService.fetchAll();
        model.addAttribute("postList", postList);
        return "adminHome/index";
    }

    //Request a GetMapping to redirect to a new html file to create a new post
    @GetMapping("/createPost")
    public String createPost() {
        return "adminHome/createPost";
    }

    //Request a PostMapping to create a new post
    @PostMapping("/index/createPost")
    public String createPost(@ModelAttribute Post post, @ModelAttribute Person person) {
        adminRepo.createPost(post, person);
        return "redirect:/";
    }


}
