package com.example.demo.Repository;

import com.example.demo.Model.Group;
import com.example.demo.Model.Person;
import com.example.demo.Model.Post;

import java.util.List;

/* GroupAction is an interface, used to specify information about the methods
needs to be implemented in the files that inherits from this interface.
The information needed is the method name and its return type of datastructure.
 */

public interface GroupAction {

    public List<Group> retrieveAllGroups();

    public List<Post> viewGroup(Group group);

    public boolean joinGroup(Group group, Person person);

    public boolean leaveGroup(Group group, Person person);

    public boolean postToGroup(Group group, Person person);

    public boolean createGroup(Group group, Person person);

    public boolean deleteGroup(int groupID);

}
