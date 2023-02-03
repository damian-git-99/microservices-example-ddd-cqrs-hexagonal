FROM maven:3.8.6-openjdk-11-slim as builder
WORKDIR /app
COPY ./users ./users
COPY ./common ./common
RUN mvn clean package

FROM openjdk:11-slim-buster
WORKDIR /app
COPY --from=builder /app/users/bootloader/target/bootloader-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "bootloader-1.0-SNAPSHOT.jar"]