FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar public-service.jar
EXPOSE 8001
CMD ["java", "-jar", "public-service.jar"]