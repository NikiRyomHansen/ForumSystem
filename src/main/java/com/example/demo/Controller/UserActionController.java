package com.example.demo.Controller;


import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.Post;
import com.example.demo.Model.PrivateMessage;
import com.example.demo.Service.*;
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
    UserGroupService userGroupService;
    @Autowired
    UserViewService userViewService;
    @Autowired
    PostService postService;
    @Autowired
    UserMessageService userMessageService;
    @Autowired
    UserUpdateService userUpdateService;
    @Autowired
    UserPostService userPostService;

    //Show a list of the person table on the login page - Niki, Khoi
    @GetMapping("/")
    public String login(Model model){
        List<Person> personList = userViewService.viewListOfPerson();
        model.addAttribute("personList", personList);
        return "userHome/loginPage";
    }

    //Send a Get request to view one person from the person table by personID - Niki
    @GetMapping("/viewOnePerson/{personID}")
    public String viewOnePerson(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "userHome/viewOnePerson";
    }

    //Shows the userFrontPage with ALL posts  and takes a personID along in the parameter - Niki
    @GetMapping("/userFrontPage/{personID}")
    public String goToUserFrontPage(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        List<Post> postList = postService.fetchAll();
        model.addAttribute("postList", postList);
        return "userHome/userFrontPage";
    }

    //Request a GetMapping to redirect to a new html file to create a new post - Niki
    @GetMapping("/createPost/{personID}")
    public String createPost(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "userHome/createPost";
    }

    //Request a PostMapping to create a new post - Niki
    @PostMapping("/userFrontPage/createPost/")
    public String createPost(@ModelAttribute Post post, @ModelAttribute Person person) {
        userPostService.createPost(post, person);
        return "redirect:/";
    }


    //Send a Post request to update one Person in the Person table - Niki
    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute Person person) {
        userUpdateService.updatePerson(person.getPersonID(), person);
        return "redirect:/";
    }

    //TODO: Add the createPost method to this controller so that any User/Person can create a post

    //open a new window that has all the needed information to create a Person in the person table - Khoi
    @GetMapping("/createUserWindow")
    public String createUserWindow(){
        return "userHome/createUserWindow";
    }

    //Create a Person in the person table
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
    @GetMapping("/groups/")
    public String retrieveAllGroups(Model model) {
        List<Group> groupList = userGroupService.retrieveAllGroups();
        model.addAttribute("Groups", groupList);
        return "userHome/groups";
    }
    // Presents the user with a specific group and its posts (Rasmus)
    @GetMapping("/groups/{groupID}")
    public String viewGroup(@PathVariable("groupID") int id, Model model, @ModelAttribute Group group) {
        model.addAttribute("group", userGroupService.viewGroup(group));
        return "userHome/groupPosts";
    }

    //  Updates the database with the user as a follower of a specific group
    @PostMapping("/joinGroup/")
    public String joinGroup(@ModelAttribute Group group, Person person) {
        userGroupService.joinGroup(group, person);
        return "redirect:/";
    }

    // Updates the database, so the user is no longer following group
    // (leaveGroup)

    // (postToGroup)

    // Returns the createNewGroup html page
    @GetMapping("/createNewGroup")
    public String createGroup() {
        return "userHome/createNewGroup";
    }

    // Creates a new group with the information given by the user.
    @PostMapping("/createNewGroup")
    public String createGroup(@ModelAttribute Group group, Person person) {
        userGroupService.createGroup(group, person);
        return "userHome/groups";
    }

    // Presents the user with the specific post and its comments (Rasmus)
    @GetMapping("/individualPost/{postID}")
    public String viewPost(@PathVariable("postID") int id, Model model) {
        model.addAttribute("comment", postService.fetchAllCommentsOnPost(id));
        return "userHome/individualPost";
    }

    // Return the messages page
    @GetMapping("/messagePage/{personID}")
    public String goToMessagePage (@PathVariable("personID") int personID, Model model){
        List<PrivateMessage> privateMessage = userMessageService.getAllPrivateMessages(personID);
        model.addAttribute("privateMessage", privateMessage);

        return "userHome/messagePage";
    }

    @GetMapping("/newMessage")
    public String goTONewMessagePage(){
        return "userHome/newMessagePage";
    }


}
