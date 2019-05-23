package com.example.demo.Controller;

import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Repository.AdminPostRepo;
import com.example.demo.Service.PostService;
import com.example.demo.Service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AdminHomeController {
    @Autowired
    PostService postService;
    @Autowired
    AdminPostRepo adminPostRepo;
    @Autowired
    UserViewService userViewService;

    //Request a GetMapping to the front page showing all posts.
    @GetMapping("/frontPage")
    public String frontPage(Model model) {
        List<Post> postList = postService.fetchAll();
        model.addAttribute("postList", postList);
        return "adminHome/frontPage";
    }

    //Request a GetMapping to redirect to a new html file to create a new post
    @GetMapping("/createPost")
    public String createPost() {
        return "adminHome/createPost";
    }

    //Request a PostMapping to create a new post - Niki
    //TODO: Not sure why this works, it should be AdminPostService - look into later (NIKI)
    @PostMapping("/frontPage/createPost")
    public String createPost(@ModelAttribute Post post, @ModelAttribute Person person) {
        adminPostRepo.createPost(post, person);
        return "redirect:/";
    }

    //Send a Get request to show all users in a list.
    @GetMapping("/viewListOfPerson")
    public String viewListOfPerson(Model model) {
        List<Person> personList = userViewService.viewListOfPerson();
        model.addAttribute("personList", personList);
        return "adminHome/viewListOfPerson";
    }

    @GetMapping("/viewOnePerson/{personID}")
    public String viewOnePerson(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "adminHome/viewOnePerson";
    }

}
