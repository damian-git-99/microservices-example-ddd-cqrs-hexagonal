FROM maven:3.8.6-openjdk-11-slim as builder
WORKDIR /app
COPY ./pom.xml .
COPY ./users ./users
COPY ./posts ./posts
COPY ./notifications ./notifications
COPY ./common ./common
RUN mvn clean package -DskipTests
#ENTRYPOINT ls notifications/notification-bootloader

FROM openjdk:11-slim-buster
WORKDIR /app
COPY --from=builder /app/posts/posts-bootloader/target/posts-bootloader-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "posts-bootloader-1.0-SNAPSHOT.jar"]