# Payment Service

Payment microservice in the e-commerce microservices project.

## Technology
- Java 17
- Spring Boot 3.3.3
- Spring Web
- Spring Data JPA
- MySQL
- Actuator
- Maven

## Port
`8083`

## Database
Create the database before starting:

```sql
CREATE DATABASE payment_db;
```

Update `src/main/resources/application.properties` with your MySQL username/password if needed.

## APIs

### Create payment
`POST http://localhost:8083/payment/v1/create`

Example body:
```json
{
  "orderId": 1,
  "amount": 1500.00,
  "paymentMethod": "CARD"
}
```

### Get all payments
`GET http://localhost:8083/payment/v1`

### Get payment by ID
`GET http://localhost:8083/payment/v1/{id}`

### Get payment by order ID
`GET http://localhost:8083/payment/v1/order/{orderId}`

### Update payment status
`PUT http://localhost:8083/payment/v1/{id}/status?status=FAILED`

## Run
```bash
mvn clean install
mvn spring-boot:run
```

This base service is intentionally kept independent. Eureka, OpenFeign, Resilience4j and Kafka can be added in the next stages of the microservices project.
