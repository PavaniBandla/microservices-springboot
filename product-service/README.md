# Product Service

Simple Spring Boot Product Microservice.

## Tech Stack

- Java 17
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- H2 Database
- Bean Validation
- Maven

## Run

```bash
mvn spring-boot:run
```

The service runs on:

http://localhost:8081

## REST APIs

### Create Product

POST `/api/products`

```json
{
  "name": "Laptop",
  "description": "Dell Laptop",
  "price": 75000,
  "quantity": 10
}
```

### Get All Products

GET `/api/products`

### Get Product By ID

GET `/api/products/{id}`

### Update Product

PUT `/api/products/{id}`

```json
{
  "name": "Updated Laptop",
  "description": "Updated description",
  "price": 80000,
  "quantity": 8
}
```

### Delete Product

DELETE `/api/products/{id}`

## H2 Console

URL:

http://localhost:8081/h2-console

JDBC URL:

`jdbc:h2:mem:productdb`

Username:

`sa`

Password:

leave empty

## Project Scope

This project intentionally contains ONLY the Product Service.

Eureka, API Gateway, Order Service, Payment Service, OpenFeign, Resilience4j, and Kafka are not included yet.
