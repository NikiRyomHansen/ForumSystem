package com.example.demo.Controller;


import com.example.demo.Model.Person;
import com.example.demo.Model.User;
import com.example.demo.Service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserActionController {
    @Autowired
    UserCreateService userCreateService;

    //Getmapping 'n' Postmapping TODO: ./login missing L22 , ./create missing L28 ./location after user has been created L34
    //TODO: @AdditionalUserinfoWindow - Unsure how to do this one-?

    @GetMapping("/")
    public String login(){
        return "userHome/loginPage";

    }

    @GetMapping("/createUserWindow")
    public String createUserWindow(){
        return "userHome/createUserWindow";
    }

    @PostMapping("/createUserWindow")
    public String createUserWindow(@ModelAttribute Person person) {
        userCreateService.createUserWindow(person);
        return "redirect:/";

    }

    //Request a PostMapping to add additional user info
    @PostMapping("/addAdditionalUserInfo")
    public String addAdditionalUserInfo(@ModelAttribute User user) {
        userCreateService.addAdditionalInfoToUser(user);
        return "redirect:/";
    }

}