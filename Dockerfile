# Stage 1: Build stage
FROM maven:3.8.4 AS build
WORKDIR /App/
COPY . /App/
RUN mvn package

# Stage 2: Final stage
FROM tomcat:latest
COPY --from=build /App/target/*.jar /usr/local/tomcat/webapps/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/usr/local/tomcat/webapps/*.jar"]
