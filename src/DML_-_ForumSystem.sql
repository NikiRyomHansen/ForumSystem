#DML til forum_system

#Test Select statements for easy access:
SELECT * FROM person;
SELECT * FROM post;
SELECT * FROM post_views;
SELECT * FROM likes;
SELECT * FROM dislikes;
SELECT * FROM comments;

USE forum_system;

#Insert values into person table
INSERT INTO person (personUsername, personPassword, email, picture, personDescription, permission)
VALUES ('Lars123', 'LarsPassword', 'LarsEmail@mail.com', null, null, 0),
       ('Niels Nielsen', 'NielsPassword', 'Niels@email.com', null, null, 0);

#Insert values into post table
INSERT INTO post(personID, postDate, changedDate, headline, textField)
VALUES(1 ,'2019-5-5 10:12:33', '2019-05-10 10:12:07', 'This just in!', 'ObamaCare shut down by Trump, boohoo');

#Insert values into post_views table
INSERT INTO post_views(postID, personID, timestampViews)
VALUES(1, 1, '2019-05-10 10:37:07');

#insert values into likes table
INSERT INTO likes(postID, personID, timestampLikes)
VALUES(1, 1, '2019-05-10 10:37:07');

#insert values into dislikes table
INSERT INTO dislikes(postID, personID, timestampDislikes, dislikeMessage)
VALUES(1, 1, '2019-05-11 10:45:00', 'I dislike this post, because it is invalid');

#Insert values into comments table
INSERT INTO comments(personID, commentText)
VALUES(1, 'This is a comment text');

#Insert values into respect_points table (Rasmus)
INSERT INTO respect_points(toUserID, fromUserID, timestampRespectPoints)
VALUES(1,2, '2019-05-22 13:53:00');

#Insert values into forum_groups table (Rasmus)
INSERT INTO forum_groups(groupName, groupDescription)
VALUES('KlatreKlanen', 'En Klan dedikeret til at klatre på ting');


#Insert values into group_members table (Rasmus)
INSERT INTO group_members(groupID, userID, permission, memberSince)
VALUES(1, 1, 0, '2019-05-22 10:00:00'),
      (1, 2, 0, '2019-05-21 21:00:00');


#Insert values into support table (Rasmus)
INSERT INTO support(sentFromUserID, category, headline, supportText, timestampSupport, isSolved)
VALUES(1, 1, 'Help with private messages',
       'Dead sir, i need help with my messages, i cant seem to get any? What is the problem', '2019-05-22 13:45:00', 0);


#Insert values into private_messages table (Rasmus)
INSERT INTO private_messages(toUserID, fromUserID, headline, message, timestampPrivateMessage, isRead)
VALUES(1, 2, 'Testing the PM system', 'Oi mate, is it working correctly? Yours truly', '2019-05-22 13:50:00', 0);


#Insert values into followers table (Rasmus)
INSERT INTO followers(toUserID, fromUserID)
VALUES(1, 2);

