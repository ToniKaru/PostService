# PostService : Lab 3 - Web Services and integrations

## Description
This is a microservice for a Twitter type application.
It will handle the services required for each user post.  

#  How to run the service
1. Create the network

   `docker create network mongo-network`

2. Create a Volume

   `docker volume create mongodb_data`

3. Start Consul

   `docker run -d -p 8500:8500 -p 8600:8600/udp --name=consul --network=mongo-network consul agent -server -ui -node=server-1 -bootstrap-expect=1 -client='0.0.0.0'`

4. Start the database

   `docker run -d --name mongodb_test --network mongo-network -e MONGO_INITDB_ROOT_USERNAME=mongoadmin -e MONGO_INITDB_ROOT_PASSWORD=secret -v mongodb_data:/data/db -p 27017:27017 mongo
`
5. Start PostService

   `docker run -d --name post-service -p 8080:8080 --network mongo-network -e  CONSUL_HOST=consul -e MONGODB_HOST=mongodb_test ghcr.io/tonikaru/postservice:latest`

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