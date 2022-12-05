FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/developer-assessment-es.jar 
COPY ${JAR_FILE}  developer-assessment-es.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","developer-assessment-es.jar"]
EXPOSE 8080