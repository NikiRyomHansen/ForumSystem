package com.example.demo.Controller;


import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.PrivateMessage;
import com.example.demo.Service.GroupService;
import com.example.demo.Service.UserCreateService;
import com.example.demo.Service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserActionController {
    @Autowired
    UserCreateService userCreateService;
    @Autowired
    GroupService groupService;
    @Autowired
    UserMessageService userMessageService;

    @GetMapping("/")
    public String login(){
        return "userHome/loginPage";
    }

    //@GetMapping("/login/frontPage")


    @GetMapping("/createUserWindow")
    public String createUserWindow(){
        return "userHome/createUserWindow";
    }

    @PostMapping("/createUserWindow")
    public String createUserWindow(@ModelAttribute Person person) {
        userCreateService.createUserWindow(person);
        return "adminHome/frontPage";
    }

    //Returns the frontpage, when the button is pressed
    @GetMapping("/userFrontPage")
    public String goToFrontPage() {
        return "userHome/userFrontPage";
    }

    //Takes the user to the groups page
    @GetMapping("/groups")
    public String goToGroups(Model model) {
        List<Group> groupList = groupService.fetchAllGroups();
        model.addAttribute("Groups", groupList);
        return "userHome/groups";
    }


    // Return the messages page
    @GetMapping("/messagePage")
    public String goToMessagePage (Model model){
        List<PrivateMessage> privateMessage = userMessageService.getAllPrivateMessages();
        model.addAttribute("privateMessage", privateMessage);

        return "userHome/messagePage";
    }
}
