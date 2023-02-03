
# Microservices

Microservices using ddd, cqrs, hexagonal architecture with spring boot.

## Architecture
- User Microservice: This microservice is responsible for managing users.
- Notification Microservice: This microservice is responsible for sending email notifications
- Posts Microservice: This microservice is responsible for creating the posts.


![Architecture](https://i.ibb.co/r434NZh/arquitectura.png)

## Use Cases
### 1. User Microservice
- Create User
- Update User
- Find User by id
- Find Users

### 2. Notification Microservice
- Send email when a user is created
- Send email when a post is created

### 3 Post Microservice
- Create post
- Delete post
- Find post
- Find Posts by user

## Run the project with docker
- Install [docker](https://www.docker.com/products/docker-desktop/)
- cd to the root of the project
- Run the command `docker-compose up -d`
