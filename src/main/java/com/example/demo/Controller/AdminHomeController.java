package com.example.demo.Controller;

import com.example.demo.Model.Post;
import com.example.demo.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AdminHomeController {
    @Autowired
    PostService postService;

    @GetMapping("/")
    public String index(Model model) {
        List<Post> postList = postService.fetchAll();
        model.addAttribute("postList", postList);
        return "adminHome/index";
    }
}
