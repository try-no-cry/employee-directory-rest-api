FROM openjdk:19
EXPOSE 8080
ADD target/employee-repository-api.jar employee-repository-api.jar
ENTRYPOINT ["java","-jar","employee-repository-api.jar"]