FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar eureka-server.jar
EXPOSE 8761
CMD ["java", "-jar", "eureka-server.jar"]