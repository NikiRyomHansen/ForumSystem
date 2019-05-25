package com.example.demo.Controller;

import com.example.demo.Service.UserViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class NavigationController {
    @Autowired
    UserViewService userViewService;


    /*//Send a Get request to view one person from the person table by personID 1 - Niki
    @GetMapping("/viewPersonIDOne/{personID}")
    public String viewPersonIDOne(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewPersonIDOne(personID));
        return "viewOnePerson";
    }*/

    //@GetMapping("/createNewGroup")

}
