#DDL til forum_system
#Create database and check if it exists
CREATE DATABASE IF NOT EXISTS forum_system;

#Use the forum_system database
USE forum_system;

#TABLES - Check if it exists on all tables
#Create user table
CREATE TABLE IF NOT EXISTS person(
	personID INT(10) NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    passwordPerson VARCHAR(255) NOT NULL, #Der er en SQL kommando der hedder password, derfor hedder kolonnen passwordPerson
    email VARCHAR(255) NOT NULL,
    picture BLOB,
    descriptionPerson VARCHAR(10000), #Der er en SQL kommando der hedder description, derfor hedder kolonnen descriptionPerson
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
    timestampDislikes timestamp NOT NULL,
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

#Create respect_points table
CREATE TABLE IF NOT EXISTS respect_points(
    respectID INT(10) NOT NULL AUTO_INCREMENT,
    toUserID INT(10) NOT NULL AUTO_INCREMENT,
    fromUserID INT(10) NOT NULL AUTO_INCREMENT,
    timestampRespectPoints timestamp NOT NULL
);

#Create groups table

#Create group_members table

#Create support table

#Create private_messages table

#Create follower table

