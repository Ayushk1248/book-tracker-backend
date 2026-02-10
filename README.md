Book Tracker Backend (Spring Boot)

1. Project Overview
This isn't just a simple CRUD app; it is a secure, fortress-like backend for managing a personal library. I built this to ensure that your reading list stays private using military-grade security (JWT) and a robust database architecture. It handles everything from locking down user passwords to serving up book data at lightning speed.

2. Technology Stack
I used the heavy hitters for this one:
- Java 17 and Spring Boot 3 for the core logic.
- Spring Security with JWT for the "bouncer at the door" authentication.
- Spring Data JPA to talk to the database without writing messy SQL.
- PostgreSQL to store the data safely.
- Swagger UI to visualize the API automatically.

3. Setup Guide
Getting this running is easier than finishing a novel.
First, make sure you have a PostgreSQL database created named "book_tracker_db".
Second, check the application.properties file to ensure your database username and password match yours.
Third, run the application using your IDE or by running the mvnw clean install command.
Once it starts, the server will be live on port 8081.

4. Explanation of the Folder Structure
I kept things organized so the code doesn't look like a mystery novel:
- controller: These are the traffic cops that handle incoming web requests.
- model: The blueprints for our data (User and Book).
- repository: The direct line to the database.
- security: Where the magic happens—JWT filters and password encryption logic.
- service: The brain of the operation that handles business logic.

5. API List
Here are the commands the app understands:
- POST /register: Signs up a new user.
- POST /authenticate: Checks credentials and hands out a security token.
- GET /books: Fetches the user's personal collection.
- POST /books: Adds a new book to the shelf.
- DELETE /books/{id}: Removes a book from the collection.

6. Auth Flow Explanation
I implemented a stateless security model. When you log in, the server checks your password (which is hashed with BCrypt, so even I can't see it). If it matches, you get a JWT (JSON Web Token). For every request after that, you show this token like a VIP pass, and the server lets you in. No sessions, no cookies, just pure secure tokens.
