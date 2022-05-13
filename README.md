# PostService : Lab 3 - Web Services and integrations

This is a microservice for a Twitter type application.
It will handle the services required for each user post.  


# Image Storage Microservice

![GitHub issues](https://img.shields.io/github/issues-raw/patlenlix/image-storage)
![GitHub pull requests](https://img.shields.io/github/issues-pr/patlenlix/image-storage)

## Description

Image upload, storage and download microservice using Spring boot, MySQL and local storage. <br/>
This service will be used for the final project of our Webservices course at IT-Högskolan, Gothenburg.

## Endpoints

| HTTP-verb | URL            | Information          | Status Code | Response Body |
|-----------|----------------|----------------------|-------------|---------------|
| POST      | /posts         | Create a post        | 201         | New post      | 
| GET       | /post/{postId} | Get a post by the id | 200         | Post          | 

POST 
