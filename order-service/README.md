# Order Service

A simple Spring Boot microservice for managing orders.

## Technology

- Java 17
- Spring Boot 3.3.3
- Spring Web
- Spring Data JPA
- MySQL
- Bean Validation
- Maven

## Database

Create the database before starting:

```sql
CREATE DATABASE order_db;
```

Update `src/main/resources/application.properties`:

```properties
spring.datasource.username=root
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

## Product Service Dependency

Product Service must be running on:

```text
http://localhost:8081
```

Order Service checks whether the requested product exists by calling:

```text
GET http://localhost:8081/api/products/{id}
```

## Run

```bash
mvn spring-boot:run
```

Order Service runs on:

```text
http://localhost:8082
```

## APIs

### Create Order

POST `http://localhost:8082/api/orders`

```json
{
  "productId": 1,
  "quantity": 2
}
```

### Get All Orders

GET `http://localhost:8082/api/orders`

### Get Order By ID

GET `http://localhost:8082/api/orders/1`

## Request Flow

```text
Postman
   |
   | POST /api/orders
   v
Order Service :8082
   |
   | GET /api/products/{id}
   v
Product Service :8081
   |
   v
Product DB
```

After product validation succeeds, the order is saved into:

```text
order_db
```
