FROM openjdk:11-slim-buster as builder
WORKDIR /app
COPY ./pom.xml ./
COPY /.mvn ./.mvn
COPY ./mvnw .
COPY ./users ./users
COPY ./common ./common

#WORKDIR /app/users/bootloader/
# RUN ./mvnw clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip && rm -r ./target/
RUN ./mvnw clean package -Dmaven.test.skip
ENTRYPOINT ls /app/users/domain

FROM openjdk:11-slim-buster
WORKDIR /app
COPY --from=builder /app/users/bootloader/target/bootloader-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "bootloader-1.0-SNAPSHOT.jar"]