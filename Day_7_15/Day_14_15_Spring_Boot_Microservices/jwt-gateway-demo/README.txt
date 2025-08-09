Run order:
1) Start Eureka: cd eureka-server && mvn spring-boot:run
2) Start User Service: cd ../user-service && mvn spring-boot:run
3) Start API Gateway: cd ../api-gateway && mvn spring-boot:run

Test with Postman:
1) Get token:
   POST http://localhost:8080/auth/login?username=avinash
   Response: <token string>

2) Call service via gateway:
   GET http://localhost:8080/user-service/users
   Header: Authorization: Bearer <token>

Direct service test:
GET http://localhost:8081/users

Notes:
- Java 11+, Maven required.
- The gateway uses a global filter to validate JWT for all requests except /auth and /actuator.
