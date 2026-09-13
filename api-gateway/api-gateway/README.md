# API Gateway

This project contains only the API Gateway.

## Current ports
- API Gateway: 8080
- Product Service: 8081
- Order Service: 8082
- Payment Service: 8083

## Routes
- `/api/products/**` -> `http://localhost:8081`
- `/api/orders/**` -> `http://localhost:8082`
- `/api/payments/**` -> `http://localhost:8083`

## Run
Start Product, Order and Payment services first, then:

```bash
mvn spring-boot:run
```

Test through the gateway:

```text
GET http://localhost:8080/api/products
GET http://localhost:8080/api/orders
GET http://localhost:8080/api/payments
```

Eureka, OpenFeign, Resilience4j and Kafka are intentionally not included yet.
When Eureka is added later, static URLs can be replaced with `lb://PRODUCT-SERVICE`, `lb://ORDER-SERVICE`, and `lb://PAYMENT-SERVICE`.
