# Auth Service

Spring Boot 3.3.3 authentication service using Spring Security, MySQL, and JWT.

## Requirements

- Java 17+
- Maven
- MySQL

## Database

Create `user_db` and the `users` table using `database.sql`.

Update `src/main/resources/application.properties`:

- `spring.datasource.username`
- `spring.datasource.password`
- `jwt.secret`

The JWT secret should be a long random value and should be supplied securely in real environments.

## Run

```bash
mvn spring-boot:run
```

Service runs on port 8083.

## Login

```http
POST http://localhost:8083/auth/login
Content-Type: application/json
```

Body:

```json
{
  "username": "john",
  "password": "your-password"
}
```

Response:

```json
{
  "token": "eyJ..."
}
```

## Architecture

Client -> Auth Service -> user_db.users

The Auth Service authenticates the database user and issues a JWT. Order Service and Product Service will validate that JWT in the next step.
