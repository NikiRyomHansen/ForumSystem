package com.example.demo.Controller;


import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.PrivateMessage;
import com.example.demo.Service.GroupService;
import com.example.demo.Service.PostService;
import com.example.demo.Service.UserCreateService;
import com.example.demo.Service.UserViewService;
import com.example.demo.Service.UserMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserActionController {
    @Autowired
    UserCreateService userCreateService;
    @Autowired
    GroupService groupService;
    @Autowired
    PostService postService;
    @Autowired
    UserMessageService userMessageService;
    @Autowired
    UserViewService userViewService;

    @GetMapping("/")
    public String login(Model model){
        List<Person> personList = userViewService.viewListOfPerson();
        model.addAttribute("personList", personList);
        return "userHome/loginPage";
    }

    @GetMapping("/userFrontPage/{personID}")
    public String goToUserFrontPage(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "userHome/userFrontPage";
    }


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

    //Takes the user to the groups page (Rasmus)
    @GetMapping("/groups")
    public String goToGroups(Model model) {
        List<Group> groupList = groupService.fetchAllGroups();
        model.addAttribute("Groups", groupList);
        return "userHome/groups";
    }
    // Presents the user with a specific group and its posts (Rasmus)
    @GetMapping("/groups/{groupID}")
    public String viewGroup(@PathVariable("groupID") int id, Model model) {
        model.addAttribute("group", groupService.fetchAllPostsFromGroup());
        return "userHome/groupPosts";
    }

    // Presents the user with the specific post and its comments (Rasmus)
    @GetMapping("/individualPost/{postID}")
    public String viewPost(@PathVariable("postID") int id, Model model) {
        model.addAttribute("comment", postService.fetchAllCommentsOnPost(id));
        return "userHome/individualPost";
    }


    // Return the messages page
    @GetMapping("/messagePage")
    public String goToMessagePage (Model model){
        List<PrivateMessage> privateMessage = userMessageService.getAllPrivateMessages();
        model.addAttribute("privateMessage", privateMessage);

        return "userHome/messagePage";
    }
}
