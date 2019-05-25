package com.example.demo.Model;

public class GroupMember {

    //Fields
    private int groupMemberID;
    private int groupID;
    private int userID;
    private int permission;
    private String memberSince;

    // Empty constructor, is used because Spring demands it
    public GroupMember() {}

    // Constructor
    public GroupMember(int groupMemberID, int groupID, int userID, int permission, String memberSince) {
        this.groupMemberID = groupMemberID;
        this.groupID = groupID;
        this.userID = userID;
        this.permission = permission;
        this.memberSince = memberSince;
    }

    // Accesors and Mutators
    public int getGroupMemberID() {
        return groupMemberID;
    }

    public void setGroupMemberID(int groupMemberID) {
        this.groupMemberID = groupMemberID;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPermission() {
        return permission;
    }

    public void setPermission(int permission) {
        this.permission = permission;
    }

    public String getMemberSince() {
        return memberSince;
    }

    public void setMemberSince(String memberSince) {
        this.memberSince = memberSince;
    }
}
