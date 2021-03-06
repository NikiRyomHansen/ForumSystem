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

    //The following lines makes sure that our Service classes are connected to our controller.
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

    //Shows the userFrontPage with ALL posts  and takes a personID along in the parameter - Niki
    @GetMapping("/userFrontPage/{personID}")
    public String userIndex(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        List<Post> postList = postService.fetchAll();
        model.addAttribute("postList", postList);
        return "userHome/userFrontPage";
    }

    //Takes the user to the groups page (Rasmus)
    @GetMapping("/groups/{personID}")
    public String retrieveAllGroups(@PathVariable("personID") int personID, Model model) {
        List<Group> groupList = userGroupService.retrieveAllGroups();
        model.addAttribute("Groups", groupList);
        return "userHome/groups";
    }

    // Presents the user with a specific group and its posts - Rasmus
    @GetMapping("/groupPosts/{groupID}")
    public String viewGroup(@PathVariable("groupID") int groupID, Model model, @ModelAttribute Group group) {
        model.addAttribute("group", userGroupService.viewGroup(group));
        return "userHome/groupPosts";
    }

    // Presents the user with the joinGroup page - Rasmus
    @GetMapping("/joinGroup")
    public String joinGroup() { return "userHome/groups"; }

    //  Updates the database with the user as a follower of a specific group - Rasmus
    @PostMapping("/joinGroup/{groupID}")
    public String joinGroup(@PathVariable("groupID") int groupID, @ModelAttribute Person person, Model model) {
        model.addAttribute("joinGroup", userGroupService.joinGroup(groupID, person));
        return "userHome/joinGroup";
    }

    // Yet to be implemented!
    // Updates the database, so the user is no longer following the group
    // (leaveGroup)

    //open a new window that has all the needed information to create a Person - Khoi, Niki
    @GetMapping("/createUserWindow")
    public String createUserWindow(){
        return "userHome/createUserWindow";
    }

    //Create a Person in the person table - Niki, Khoi
    @PostMapping("/createUserWindow")
    public String createUserWindow(@ModelAttribute Person person) {
        userCreateService.createUserWindow(person);
        return "redirect:/";
    }

    //Sends a Get request to view one person from the person table by personID - Niki
    @GetMapping("/viewOnePerson/{personID}")
    public String viewOnePerson(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "userHome/viewOnePerson";
    }

    //Request a GetMapping to redirect to a new html file to create a new post - Niki, Rasmus
    @GetMapping("/createPost/{personID}")
    public String createPost(@PathVariable("personID") int personID, Model model) {
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "userHome/createPost";
    }

    //Request a PostMapping to create a new post - Niki, Rasmus
    @PostMapping("/userFrontPage/createPost/")
    public String createPost(@ModelAttribute Post post, @ModelAttribute Person person) {
        userPostService.createPost(post, person);
        return "redirect:/";
    }

    // Presents the user with the specific post and its comments - Rasmus
    @GetMapping("/individualPost/{postID}")
    public String viewPost(@PathVariable("postID") int postID, Model model) {
        model.addAttribute("comment", postService.fetchAllCommentsOnPost(postID));
        return "userHome/individualPost";
    }

    //Requests a GetMapping to be able to edit the post - Niki
    @GetMapping("/editOnePost/{postID}")
    public String editOnePost(@PathVariable("postID") int postID, Model model) {
        model.addAttribute("post", userPostService.viewOnePost(postID));
        return "userHome/editOnePost";
    }

    //Sends a Post request to the web application to edit the post table in the database
    @PostMapping("/editOnePost")
    public String editOnePost(@ModelAttribute Post post) {
        userPostService.editPost(post.getPostID(), post);
        return "redirect:/";
    }

    // Sends a get mapping request to the web application and delete post from database
    @GetMapping("/deletePost/{postID}")
    public String deletePost(@PathVariable("postID") int postID) {
        userPostService.deletePost(postID);
        return "redirect:/";
    }

    //Sends a Post request to update one Person in the Person table - Niki
    @PostMapping("/updatePerson")
    public String updatePerson(@ModelAttribute Person person) {
        userUpdateService.updatePerson(person.getPersonID(), person);
        return "redirect:/";
    }

    // (postToGroup)

    // Returns the createNewGroup html page
    @GetMapping("/createNewGroup")
    public String createGroup() {
        return "userHome/createNewGroup";
    }

    // Creates a new group with the information given by the user. - Rasmus
    @PostMapping("/createNewGroup")
    public String createGroup(@ModelAttribute Group group, Person person) {
        userGroupService.createGroup(group, person);
        return "redirect:/";
    }

    // Deletes a group - Rasmus
    @GetMapping("/deleteGroup/{groupID}")
    public String deleteGroup(@PathVariable("groupID") int groupID, Model model) {
        model.addAttribute("deleteGroup", userGroupService.deleteGroup(groupID));
        return "redirect:/";
    }


    // Return the messages page and a list of messages
    @GetMapping("/messagePage/{personID}")
    public String retrievePrivateMessages(@PathVariable("personID") int personID, Model model){
        List<PrivateMessage> privateMessage = userMessageService.getAllPrivateMessages(personID);
        model.addAttribute("privateMessage", privateMessage);
        return "userHome/messagePage";
    }

    // Go to NewMessagePage @GetMapping
    @GetMapping("/newMessagePage/{personID}")
    public String createNewPrivateMessage(@PathVariable("personID") int personID, Model model){
        model.addAttribute("person", userViewService.viewOnePerson(personID));
        return "userHome/newMessagePage";
    }

    // Under construction...
    @PostMapping("/messagePage/{personID}")
    public String sendPrivateMessage(@PathVariable("personID") int personID, Person toUser, Person fromUser, PrivateMessage message, Model model){


        return "userHome/messagePage";
    }

}
