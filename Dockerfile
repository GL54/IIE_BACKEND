FROM maven:3.9.6-openjdk-17 AS build
COPY . .
RUN mvn clean package —DskipTests

FROM openjdk:17.0.10-jdk-slim
COPY —from-build 'target/iieweb-0.0.1-SNAPSHOT.jar iieweb.jar'
EXPOSE 8080
ENTRYPOINT ["java"," —jar" , "iieweb.jar"]