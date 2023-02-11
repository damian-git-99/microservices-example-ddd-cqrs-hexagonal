
# Microservices

Microservices using ddd, cqrs, event-based communication, hexagonal architecture with spring boot.

## Architecture
- User Microservice: This microservice is responsible for managing users.
- Notification Microservice: This microservice is responsible for sending email notifications
- Posts Microservice: This microservice is responsible for creating the posts.


![Architecture](https://i.ibb.co/xX9kYkd/Captura-de-pantalla-2023-02-10-170648.png)

## Use Cases
### 1. User Microservice
- Create User
- Update User
- Find User by id
- Find Users

### 2. Notification Microservice
- Send email notification when a user is created

### 3 Post Microservice
- Create post
- Delete post
- Find post
- Find Posts by user

## Run the project with docker
- clone the project `git clone https://github.com/damian-git-99/microservices-example-ddd-cqrs-hexagonal.git`
- Notification Service config
    * To send emails a gmail account is used, so you have to generate an application password: following the steps below https://support.google.com/mail/answer/185833?hl=en-GB
    * Set the email and password in the file `docker-compose.yml` in the environment variables of the service `notifications`
- Install [docker](https://www.docker.com/products/docker-desktop/)
- cd to the root of the project
- Run the command `docker-compose up -d`

#### If you make any changes in the code you need to rebuild the images of the microservices and push them to docker hub
- Install [maven](https://maven.apache.org/install.html)
- change docker user in the root file `pom.xml` in property `image` and in `docker-compose.yml` in property `image`
- docker login with your docker hub credentials `docker login`
- cd to the root of the project
- Run the command `mvn clean -P build-docker-image package`

## API Reference
### 1. User Microservice ```http://localhost:8080```
- Create User: ```POST /api/v1/users```
with body:
```json
{
  "username": "foo",
  "email": "foo@mail.com",
  "id": "550e8400-e29b-41d4-a716-446655440000"
}
```
- Delete User: ```DELETE /api/v1/users/{id}```
- Find User by id: ```GET /api/v1/users/{id}```
- Find Users: ```GET /api/v1/users```

### 2. Post Microservice ```http://localhost:8082```
- Create Post: ```POST /api/v1/posts```
with body:
```json
{
  "id": "3e8c2b0a-7b1f-4b3e-8c1c-8c1c8c1c8c1c",
  "title": "foo",
  "content": "foo",
  "userId": "550e8400-e29b-41d4-a716-446655440000"
}
```
- Delete Post: ```DELETE /api/v1/posts/{id}```
- Find Post by id: ```GET /api/v1/posts/{id}```
- Find Posts by user: ```GET /api/v1/posts/user-posts/{userId}```
