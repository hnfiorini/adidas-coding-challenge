FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar subscription-service.jar
EXPOSE 8002
CMD ["java", "-jar", "subscription-service.jar"]