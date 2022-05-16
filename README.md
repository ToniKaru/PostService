# PostService : Lab 3 - Web Services and integrations

## Description
This is a microservice for a Twitter type application.
It will handle the services required for each user post.  

## Start
1. Create network
2. Start Consul
3. Start the database
   `docker run -d --name mongodb_test --network mongo-network -e MONGO_INITDB_ROOT_USERNAME=mongoadmin 
   -e MONGO_INITDB_ROOT_PASSWORD=secret -v mongodb_test:/data/db -p 27017:27017 mongo`
4. Start this service

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