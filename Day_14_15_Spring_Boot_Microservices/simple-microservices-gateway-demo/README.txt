
Simple microservices gateway demo (no Docker).
Structure:
- eureka-server (port 8761)
- api-gateway (port 8080) - uses discovery locator to route to services
- user-service (port 8081) - /users endpoint
- sms-service (port 8082) - /sms endpoint

How to run (from project module folder):
1) Start Eureka:
   cd eureka-server
   mvn spring-boot:run

2) Start user service:
   cd ../user-service
   mvn spring-boot:run

3) Start sms service:
   cd ../sms-service
   mvn spring-boot:run

4) Start API Gateway:
   cd ../api-gateway
   mvn spring-boot:run

Requests via gateway (note prefixes used in gateway routes):
- http://localhost:8080/user-service/users
- http://localhost:8080/sms-service/sms

Notes:
- Java 11+ and Maven required.
- Spring Boot 2.7.13 and Spring Cloud 2021.0.8 are referenced in each module pom.
