#DDL til forum_system
#Create database and check if it exists
CREATE DATABASE IF NOT EXISTS forum_system;

#Use the forum_system database
USE forum_system;

#TABLES - Check if it exists on all tables
#Create user table
CREATE TABLE IF NOT EXISTS person(
	personID INT(10) NOT NULL AUTO_INCREMENT,
    personUsername VARCHAR(255) NOT NULL,
    personPassword VARCHAR(255) NOT NULL, #Der er en SQL kommando der hedder password, derfor hedder kolonnen passwordPerson
    email VARCHAR(255) NOT NULL,
    picture BLOB,
    personDescription VARCHAR(10000), #Der er en SQL kommando der hedder description, derfor hedder kolonnen descriptionPerson
    permission INT(1) NOT NULL, #Muligvis ændre denne til INT(1) da der aldrig komme mere end ét cifrede permissions.
    PRIMARY KEY (personID)
);

#Create post table
CREATE TABLE IF NOT EXISTS post(
	postID INT(10) NOT NULL AUTO_INCREMENT,
    personID INT(10) NOT NULL,
    postDate TIMESTAMP NOT NULL,
    changedDate TIMESTAMP,
    headline VARCHAR(255) NOT NULL,
    textField VARCHAR(10000) NOT NULL, #SQL kommando som hedder text, derfor bruges textField.
    PRIMARY KEY (postID),
    FOREIGN KEY (personID) REFERENCES person(personID)
);

#Create views table
CREATE TABLE IF NOT EXISTS post_views(
	viewsID INT(10) NOT NULL AUTO_INCREMENT,
    postID INT(10) NOT NULL,
    personID INT(10) NOT NULL,
    timestampViews TIMESTAMP NOT NULL,
    PRIMARY KEY (viewsID),
    FOREIGN KEY (postID) REFERENCES post(postID),
    FOREIGN KEY (personID) REFERENCES person(personID)
);

#Create likes table
CREATE TABLE IF NOT EXISTS likes(
	likesID INT(10) NOT NULL AUTO_INCREMENT,
    postID INT(10) NOT NULL,
    personID INT(10) NOT NULL,
    timestampLikes TIMESTAMP NOT NULL,
    PRIMARY KEY (likesID),
    FOREIGN KEY (personID) REFERENCES person(personID),
    FOREIGN KEY (postID) REFERENCES post(postID)
);

#Create dislikes table
CREATE TABLE IF NOT EXISTS dislikes(
	dislikeID INT(10) NOT NULL AUTO_INCREMENT,
    postID INT(10) NOT NULL,
    personID INT(10) NOT NULL,
    timestampDislikes TIMESTAMP NOT NULL,
    dislikeMessage VARCHAR(255) NOT NULL,
    PRIMARY KEY (dislikeID),
    FOREIGN KEY (postID) REFERENCES post(postID),
    FOREIGN KEY (personID) REFERENCES person(personID)
);

#Create comments table
CREATE TABLE IF NOT EXISTS comments(
	commentID INT(10) NOT NULL AUTO_INCREMENT,
    personID INT(10) NOT NULL,
    commentText VARCHAR(10000) NOT NULL,
    PRIMARY KEY (commentID),
    FOREIGN KEY (personID) REFERENCES person(personID)
);

#Create respect_points table (Rasmus)
CREATE TABLE IF NOT EXISTS respect_points(
    respectID INT(10) NOT NULL AUTO_INCREMENT,
    toUserID INT(10) NOT NULL,
    fromUserID INT(10) NOT NULL,
    timestampRespectPoints TIMESTAMP NOT NULL,
    PRIMARY KEY (respectID),
    FOREIGN KEY (toUserID) REFERENCES person(personID),
    FOREIGN KEY (fromUserID) REFERENCES person(personID)
);

#Create groups table (Rasmus)
CREATE TABLE IF NOT EXISTS forum_groups(
    groupID INT(10) NOT NULL AUTO_INCREMENT,
    groupName VARCHAR(255) NOT NULL,
    groupDescription VARCHAR(10000) NOT NULL,
    PRIMARY KEY (groupID)
);

#Create group_members table (Rasmus)
CREATE TABLE IF NOT EXISTS group_members(
    groupMemberID INT(10) NOT NULL AUTO_INCREMENT,
    groupID INT(10) NOT NULL,
    userID INT(10) NOT NULL,
    permission INT(1) NOT NULL,
    memberSince TIMESTAMP NOT NULL,
    PRIMARY KEY (groupMemberID),
    FOREIGN KEY (groupID) REFERENCES forum_groups(groupID),
    FOREIGN KEY (userID) REFERENCES person(personID)
);

#Create support table (Rasmus)
CREATE TABLE IF NOT EXISTS support(
    supportID INT(10) NOT NULL AUTO_INCREMENT,
    sentFromUserID INT(10) NOT NULL,
    category INT(10) NOT NULL,
    headline VARCHAR(255) NOT NULL,
    supportText VARCHAR(10000) NOT NULL,
    timestampSupport TIMESTAMP NOT NULL,
    isSolved BIT NOT NULL,
    PRIMARY KEY (supportID),
    FOREIGN KEY (sentFromUserID) REFERENCES person(personID)
);

#Create private_messages table (Rasmus)
CREATE TABLE IF NOT EXISTS private_messages(
    privateMessageID INT(10) NOT NULL AUTO_INCREMENT,
    toUserID INT(10) NOT NULL,
    fromUserID INT(10) NOT NULL,
    headline VARCHAR(255) NOT NULL,
    message VARCHAR(10000) NOT NULL,
    timestampPrivateMessage TIMESTAMP NOT NULL,
    isRead BIT NOT NULL,
    PRIMARY KEY (privateMessageID),
    FOREIGN KEY (toUserID) REFERENCES person(personID),
    FOREIGN KEY (fromUserID) REFERENCES person(personID)
);

#Create follower table (Rasmus)
CREATE TABLE IF NOT EXISTS followers(
    followerID INT(10) NOT NULL AUTO_INCREMENT,
    toUserID INT(10) NOT NULL,
    fromUserID INT(10) NOT NULL,
    PRIMARY KEY (followerID),
    FOREIGN KEY (toUserID) REFERENCES person(personID),
    FOREIGN KEY (fromUserID) REFERENCES person(personID)
);

