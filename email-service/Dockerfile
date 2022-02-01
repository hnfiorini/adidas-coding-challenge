FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar email-service.jar
EXPOSE 8003
CMD ["java", "-jar", "email-service.jar"]