FROM maven:3.8.6-openjdk-11-slim as builder
WORKDIR /app
# copy poms
COPY ./pom.xml .
# common
COPY ./common/pom.xml ./common/pom.xml
COPY ./common/domain-common/pom.xml ./common/domain-common/pom.xml
COPY ./common/infrastructure-common/pom.xml ./common/infrastructure-common/pom.xml
# users
COPY ./users/pom.xml ./users/pom.xml
COPY ./users/users-domain/pom.xml ./users/users-domain/pom.xml
COPY ./users/users-application/pom.xml ./users/users-application/pom.xml
COPY ./users/users-bootloader/pom.xml ./users/users-bootloader/pom.xml
COPY ./users/users-infrastructure/pom.xml ./users/users-infrastructure/pom.xml
## users/infrastructure
COPY ./users/users-infrastructure/users-rest/pom.xml ./users/users-infrastructure/users-rest/pom.xml
COPY ./users/users-infrastructure/users-messaging/pom.xml ./users/users-infrastructure/users-messaging/pom.xml
COPY ./users/users-infrastructure/mysql-users-repository/pom.xml ./users/users-infrastructure/mysql-users-repository/pom.xml
RUN mvn clean package -Dmaven.test.skip -Dmaven.main.skip -Dspring-boot.repackage.skip
# copy source code
COPY ./users ./users
COPY ./common ./common
RUN mvn clean package -DskipTests

# Run the app
FROM openjdk:11-slim-buster
WORKDIR /app
COPY --from=builder /app/users/users-bootloader/target/bootloader-1.0-SNAPSHOT.jar .
EXPOSE 8080
CMD ["java", "-jar", "bootloader-1.0-SNAPSHOT.jar"]