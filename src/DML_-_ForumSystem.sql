#DML til forum_system

USE forum_system;

#Insert values into person table (Rasmus)
INSERT INTO person (personUsername, personPassword, email, picture, personDescription, permission)
VALUES ('Lars Larsen', 'LarsPassword', 'Lars@email.com', null, null, 0),
       ('Niels Nielsen', 'NielsPassword', 'Niels@email.com', null, null, 0),
       ('Thomas Thomasen', 'ThomasPassword', 'Thomas@email.com', null, null, 0),
       ('Admin', 'AdminPassword', 'Admin@email.com', null, null, 1),
       ('Poul Poulsen', 'PoulPassword', 'Poul@email.com', null, null, 0);

#Insert values into forum_groups table (Rasmus)
INSERT INTO forum_groups(groupName, groupDescription)
VALUES ('ClimbingClan', 'A clan dedicated to climbing on things'),
       ('CSS for dummies', 'A fora dedicated to the art of CSS'),
       ('DAT18D', 'A place for everyone studying Computer Science at KEA');


#Insert values into group_members table (Rasmus)
INSERT INTO group_members(groupID, userID, permission, memberSince)
VALUES (1, 1, 0, '2019-05-10 10:45:07'),
       (1, 2, 0, '2019-05-17 14:42:11'),
       (1, 4, 1, '2019-05-17 18:35:01'),
       (2, 2, 1, '2019-05-14 12:11:09'),
       (2, 3, 0, '2019-05-16 20:23:15'),
       (3, 1, 1, '2019-05-13 09:10:44'),
       (3, 2, 0, '2019-05-24 13:05:59'),
       (3, 3, 0, '2019-05-27 11:45:04');

#Insert values into post table (Rasmus)
INSERT INTO post(belongsToGroup, personID, postDate, changedDate, headline, textField)
VALUES (1, 1, '2019-05-5 10:12:33', '2019-05-10 10:12:07', 'Large boulder found on Faelleden', 'Have to climbed on it yet??'),
       (2, 2, '2019-05-6 14:00:00', null, 'Comments in CSS??', 'I cant seem to comment in CSS, how to I do this??'),
       (1, 2, '2019-05-24 10:00:00', null, 'Climbing is the new black', 'A new study shows that climbing is becoming increasingly popular'),
       (1, 4, '2019-05-10 15:33:12', null, 'Belay Partner needed', 'Hi here, im in need of an Belay Partner in the vinicity of Copenhagen. Anyone up for some climbing action?'),
       (2, 2, '2019-05-15 09:00:45', null, 'Lets make somthing together', 'Hi there! I have this crazy idea... Anyone up for creating an app with CSS. I dont know anything about coding, but i have a gread idea!'),
       (2, 3, '2019-05-16 23:20:33', null, 'How to align two input fields in CSS?', 'I have this problem, I cant seem to align two text inputs on the same page. Anyone have any tips on a solution'),
       (3, 1, '2019-05-17 14:10:46', null, 'Does anyone know when the holidays start?',
        'I cant seem to figure out, when we are done with school for the 2. semester.Does anyone know ? '),
       (3, 2, '2019-05-20 23:00:04', null, 'Did anyone get the point from Tech today?', 'The Teacher talked about somehing about encryption/hashing... What is the difference.');

#Insert values into post_views table (Rasmus)
INSERT INTO post_views(postID, personID, timestampViews)
VALUES (1, 1, '2019-05-10 10:37:07'),
       (1, 2, '2019-05-10 13:10:01'),
       (1, 4, '2019-05-10 14:00:13'),
       (2, 2, '2019-05-14 09:03:13'),
       (2, 3, '2019-05-14 10:24:44'),
       (2, 4, '2019-05-14 23:00:15'),
       (3, 5, '2019-05-16 15:46:11'),
       (3, 4, '2019-05-16 16:13:55'),
       (4, 1, '2019-05-17 12:45:00'),
       (4, 2, '2019-05-17 13:00:14'),
       (4, 3, '2019-05-17 13:04:30'),
       (5, 2, '2019-05-19 09:55:03'),
       (5, 5, '2019-05-19 11:04:22'),
       (6, 1, '2019-05-20 15:22:05'),
       (6, 4, '2019-05-20 16:10:14'),
       (7, 3, '2019-05-21 20:41:11'),
       (7, 5, '2019-05-21 21:04:00'),
       (8, 1, '2019-05-22 21:55:32'),
       (8, 3, '2019-05-22 22:45:07');

#insert values into likes table (Rasmus)
INSERT INTO likes(postID, personID, timestampLikes)
VALUES (1, 1, '2019-05-10 10:37:07'),
       (1, 2, '2019-05-10 13:20:33'),
       (2, 4, '2019-05-15 14:32:00'),
       (3, 5, '2019-05-16 23:33:04'),
       (3, 4, '2019-05-16 23:45:11'),
       (5, 1, '2019-05-20 12:03:45'),
       (6, 4, '2019-05-21 13:44:23'),
       (8, 3, '2019-05-22 17:32:00'),
       (8, 5, '2019-05-23 12:00:32');

#insert values into dislikes table (Rasmus)
INSERT INTO dislikes(postID, personID, timestampDislikes, dislikeMessage)
VALUES (1, 1, '2019-05-11 10:45:00', 'I dislike this post, because it does not agree with my point of view'),
       (3, 2, '2019-05-16 15:23:45', 'I find this post offensive, please remove it!'),
       (5, 4, '2019-05-20 23:03:42', 'The post contains factual errors, that steer the topic in the wrong direction. Stay on point');

#Insert values into comments table (Rasmus)
INSERT INTO comments(personID, postID, commentText)
VALUES (1, 1, 'I did a sick send the other day, mate!'),
       (2, 1, 'I dont know where it is, can any guide me in the right direction?'),
       (4, 1, 'It is right beside the two soccer fields, in the direction of the lake.Hope you find it, mate!'),
       (3, 2, 'CSS uses block comments, just like the C-like languages. Use "/*" as the start and "*/" as the end'),
       (5, 8, 'Basically, we use encryption when we need the information for something, and use hashing, when we dont
        need the information for something specific.If we just need to compare two things - Like a provided password and
        the password in the databse - hashing is best, since we do not need to know what the passwrod is,
        just that they are the same');

#Insert values into respect_points table (Rasmus)
INSERT INTO respect_points(toUserID, fromUserID, timestampRespectPoints)
VALUES (1, 2, '2019-05-22 13:53:00'),
       (5, 1, '2019-05-23 15:00:11'),
       (5, 2, '2019-05-10 11:54:23'),
       (5, 4, '2019-05-17 18:42:10');

#Insert values into support table (Rasmus)
INSERT INTO support(sentFromUserID, category, headline, supportText, timestampSupport, isSolved)
VALUES (1, 1, 'Help with private messages',
        'Dear sir, i need help with my messages, i cant seem to get any? What is the problem',
        '2019-05-22 13:45:00', 0),
       (3, 2, 'Trouble with entering groups', 'Hi there! When i try to join a group, nothing seems to happen. Why does it not work?', '2019-05-24 23:42:04', 0);


#Insert values into private_messages table (Rasmus)
INSERT INTO private_messages(toUserID, fromUserID, headline, message, timestampPrivateMessage, isRead)
VALUES (2, 3, 'Hi there!', 'Do you have the coordinates for that boulder ind Faelleden? I would really love to try it out', '2019-05-22 13:50:00', 0),
       (3, 2, 'Hi there!', 'Sadly no, but i recommend you to either look at google maps, right beside the football fields or just going out there and explore!', '2019-05-23 20:23:00', 0);


#Insert values into followers table (Rasmus)
INSERT INTO followers(toUserID, fromUserID)
VALUES (5, 2),
       (5, 1),
       (5, 3);

