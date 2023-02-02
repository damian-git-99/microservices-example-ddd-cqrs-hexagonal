FROM openjdk:11-slim-buster as builder
WORKDIR /app
COPY ./target/bootloader-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "bootloader-1.0-SNAPSHOT.jar"]