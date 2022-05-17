# PostService : Lab 3 - Web Services and integrations

## Description
This is a microservice for a Twitter type application.
It will handle the services required for each user post.  

## Endpoints

| HTTP-verb | URL        | Information          | Status Code | Response Body |
|-----------|------------|----------------------|-------------|---------------|
| POST      | /posts     | Create a post        | 201         | New post      | 
| GET       | /post/{id} | Get a post by its id | 200         | Post          | 

POST accepts the following Json body (parentId is optional)
```json
{
  "text": "My test post",
  "userId": "leela@futurama.com",
  "parentId": "idOfParentPost"
}
```

Contributors: Toni & Ahsan