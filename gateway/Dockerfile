FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar gateway.jar
EXPOSE 8080
CMD ["java", "-jar", "gateway.jar"]