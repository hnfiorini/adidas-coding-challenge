# adidas-coding-challenge

![alt text](https://github.com/hnfiorini/adidas-coding-challenge/blob/main/diagram.png?raw=true)

## Main idea
- We could have diferents Public service (backend for frontend) for different types of clients
- We make REST calls against our API gateway
- This is our only entry point to the internal part of our system where we could apply filters, security, redirection, etc.
- From here we redirect to our Subscription Service
- subscription-service save into our database and send a message to a queue (RabbitMQ)
- email-service is subscribed to this queue and receives the message in order to send the corresponding mail.
- Here we have an asynchronous communication since the subscription-service does not expect an immediate response from the email-service.
- For all of this we use Eureka as service discovery

## Pendings
- Test
- Security
- Complete implementation of circuit breaker
- CI/CD
- Alternative flows / Errors
- Dockerization
- Swagger of PublicService (there is an unresolved error with the Spring version 2.6.3 with version of Swagger)

## Frameworks
- Lombok
- Swagger
- Eureka
- Spring Cloud Gateway
- Spring Cloud Circuit Breaker Resilence4j
