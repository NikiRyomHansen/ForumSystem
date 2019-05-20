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
INSERT INTO person (username, passwordPerson, email, picture, descriptionPerson, permission)
VALUES ('Lars123', 'LarsPassword', 'LarsEmail@mail.com', null, null, 0);

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

INSERT INTO comments(personID, commentText)
VALUES(1, 'This is a comment text');