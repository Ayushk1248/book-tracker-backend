# Book Tracker Backend

## 1. Project Overview
A secure REST API developed with Spring Boot to manage personal book collections. It ensures data security through JWT-based authentication, allowing users to register, login, and manage their private book lists.

## 2. Technology Stack
* Java 17, Spring Boot 3
* PostgreSQL, Spring Data JPA
* Spring Security, JWT (JSON Web Tokens)
* Swagger UI

## 3. Setup Guide
1. **Database:** Create a PostgreSQL database named `book_tracker_db`.
2. **Config:** Update `src/main/resources/application.properties` with your database credentials.
3. **Build:** Run `./mvnw clean install`.
4. **Run:** Start the application. Server runs on `http://localhost:8081`.

## 4. Explanation of Folder Structure
* `controller`: Handles incoming API requests (Auth and Books).
* `model`: Database entities (User, Book).
* `repository`: Interfaces for database operations.
* `security`: JWT filters and password encryption logic.
* `service`: Business logic layer.

## 5. API List
* `POST /register` - Register a new user.
* `POST /authenticate` - Login and receive JWT.
* `GET /books` - Retrieve all books for the logged-in user.
* `POST /books` - Add a new book.
* `DELETE /books/{id}` - Delete a book by ID.

## 6. Auth Flow Explanation
1. User sends credentials to `/authenticate`.
2. Server validates them and returns a signed **JWT**.
3. Client stores this token.
4. Future requests include the token in the `Authorization` header (`Bearer <token>`).
5. Server validates the token before allowing access to data.
