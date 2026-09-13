# Eureka Service Discovery

Standalone Eureka Server for the microservices project.

## Requirements

- Java 17+
- Maven 3.9+

## Run

```bash
mvn spring-boot:run
```

Or build and run:

```bash
mvn clean package
java -jar target/eureka-service-discovery-0.0.1-SNAPSHOT.jar
```

Open the Eureka dashboard:

http://localhost:8761

## Important

This project only creates the Eureka Server. The Product Service, Order Service,
Payment Service, and API Gateway must be updated separately to register with Eureka.
