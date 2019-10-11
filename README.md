# Springboot-Project

This project were using Java and Spring Framework to build a backend for our Reddit-like application.

Our inital design plan for our databases:
![Database Schema for Spillit](https://i.imgur.com/HqR9H2K.jpg)

We planned to have a User table with columns id, username(a unique tag so the user's can't register with the same usernames) and password. The Posts table has id, title(which is the header of the post box), text(the body of post box) and user_id as a foreign key to connect user's to posts. Lastly, a Comment table has id, text, post_id as a foreign key(comments must be attached to a post) and user_id as another foreign key(a comment is posted by a user).

Our design updated as we coded. We had created a userRole collection for authorization purposes then had to comment out and delete due to errors in Postman.

Some challenges our team experience:

- Work flow: Both of us were building the backend simulaneously working on the same files instead of splitting the work

- Them beans tho: We had issues with getting our application to run in the beginning of the week

- Push and pulling: There were instances where one of us would commit and push and the other would pull and the content from the updated files caused "Failed to Start Application" errors. We got around that issue by zipping our latest code and sending it over Slack

- Inconsistencies in our code: Looking at the errors through Postman the datatypes were not the same. An example is for deleting a post, in some areas we initialized postId as long and other places as int.
