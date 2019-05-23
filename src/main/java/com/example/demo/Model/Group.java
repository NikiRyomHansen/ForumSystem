package com.example.demo.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Group implements Serializable {

    @Id
    //Fields
    private int groupID;
    private String groupName;
    private String groupDescription;

    public Group() {}

    // Constructor
    public Group(int groupID, String groupName, String groupDescription) {
        this.groupID = groupID;
        this.groupName = groupName;
        this.groupDescription = groupDescription;
    }

    // Accesors and Mutators
    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupDescription() {
        return groupDescription;
    }

    public void setGroupDescription(String groupDescription) {
        this.groupDescription = groupDescription;
    }
}
