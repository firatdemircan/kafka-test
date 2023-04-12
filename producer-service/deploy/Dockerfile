FROM openjdk:17-alpine
#FROM maven:3-openjdk-17 AS build
COPY *.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]