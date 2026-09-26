CREATE DATABASE IF NOT EXISTS user_db;
USE user_db;

CREATE TABLE IF NOT EXISTS users (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL
);

-- Generate a BCrypt hash for your password before inserting a user.
-- Example role values: USER, ADMIN
-- INSERT INTO users (username, password, role)
-- VALUES ('john', '$2a$10$REPLACE_WITH_BCRYPT_HASH', 'USER');
