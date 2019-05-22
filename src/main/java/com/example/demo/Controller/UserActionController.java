package com.example.demo.Controller;


import com.example.demo.Model.User;
import com.example.demo.Repository.UserCreateRepo;
import com.example.demo.Service.UserCreateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserActionController {
    @Autowired
    UserCreateRepo userCreateRepo;

    //Getmapping 'n' Postmapping TODO: ./login missing L22 , ./create missing L28 ./location after user has been created L34
    //TODO: @AdditionalUserinfoWindow - Unsure how to do this one-?

    @GetMapping("/login")
    public String login(){
        return "adminHome/login";

    }

    @GetMapping("/CreateUserWindow")
    public String CreateUserWindow(){
        return "adminHome/create";
    }

    @PostMapping("CreateUserWindow")
    public String CreateUser(@ModelAttribute User user){
       userCreateRepo.CreateUser(user);
       return "adminHome/To_be_done";


    //Missing - @AdditionalUserInfoWindow

    }


}
