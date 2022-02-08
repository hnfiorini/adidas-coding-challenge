FROM openjdk:8-jdk-alpine
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY target/*.jar gateway-service.jar
EXPOSE 8005
CMD ["java", "-jar", "gateway-service.jar"]