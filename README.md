# Springboot-Project

This project were using Java and Spring Framework to build a backend for our Reddit-like application.

Our inital design plan for our databases:
![Database Schema for Spillit](https://i.imgur.com/HqR9H2K.jpg)

We planned to have a User table with columns id, username(a unique tag so the user's can't register with the same usernames) and password. The Posts table has id, title(which is the header of the post box), text(the body of post box) and user_id as a foreign key to connect user's to posts. Lastly, a Comment table has id, text, post_id as a foreign key(comments must be attached to a post) and user_id as another foreign key(a comment is posted by a user).
