FROM maven:3.9.6-openjdk-17 AS build
COPY . .
RIN mvn clean package —DskipTests
FROM
COPY —from-build 'target/iieweb-0.0.1-SNAPSHOT.jar iieweb.jar
EXPOSE 8080
ENTRYPOINT ["java" —jar" , "iieweb. jar"]