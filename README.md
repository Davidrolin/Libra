# Libra - Book Management & Tracking System

A full-stack Java web application built with Spring Boot and Thymeleaf. The application allows users to manage a personal book library, track reading progress and rate books.

This project demonstrates core Java principles, Object-Oriented Programming (OOP), clean 3-layer architecture, and server-side rendering using modern Spring MVC patterns.

---

## Features

- Book Catalog Management: Add new books with detailed metadata (Title, Author, Publication Year, Genre).
- Reading Tracker: Mark books as read/unread and assign ratings (1–5 Stars).
- Library Actions: Delete books or update ratings dynamically from the UI.
- Server-Side Rendering: Clean HTML/CSS interface rendered using Thymeleaf template engine.

---

## Architecture & Tech Stack

### Tech Stack
- Language: Java 25
- Framework: Spring Boot 3.2.4 (Spring MVC)
- Template Engine: Thymeleaf
- Build Tool: Maven
- In-Memory Storage: Domain Services (ArrayList-backed)

### Design Patterns & Principles
- Three-Layer Architecture: Separation of concerns into Domain Models, Service Layer, and Web Controllers.
- Dependency Injection (DI): Constructor-based injection (final dependencies) for thread safety and immutability.
- Encapsulation & Domain Validation: Robust setters and domain validation ensuring invalid data is rejected at the model level.

---

## Getting Started

### Prerequisites
- JDK: Java 17 or higher (Java 25 supported)
- Build Tool: Maven

### Running the Application

1. Clone the repository:
   git clone [https://github.com/your-username/libra.git](https://github.com/your-username/libra.git)
   cd libra

2. Run using Maven:
   ./mvnw spring-boot:run

3. Open in browser:
   Navigate to http://localhost:8080/books in your web browser.

---

## Roadmap & To-Do List

- [x] Phase 1: Core Domain & Web MVC Interface
    - [x] Implement robust Book domain model with validation & B.C. date formatting.
    - [x] Build BookCollection service using in-memory collection.
    - [x] Implement BookController with Spring MVC routing (@GetMapping, @PostMapping).
    - [x] Render UI using Thymeleaf (books.html).

- [ ] Phase 2: Database Integration (Spring Data JPA & SQL)
    - [ ] Add Spring Data JPA and H2/PostgreSQL dependencies.
    - [ ] Map Book domain model to a relational database table using @Entity.
    - [ ] Replace in-memory BookCollection with a Spring Data BookRepository.
    - [ ] Implement database migrations (Flyway or Liquibase).

- [ ] Phase 3: User Authentication & Security (Spring Security)
    - [ ] Integrate Spring Security framework.
    - [ ] Create User and Role entities with password hashing (BCrypt).
    - [ ] Implement registration and login/logout views.
    - [ ] Associate book collections directly with individual user accounts.

- [ ] Phase 4: REST API Expansion
    - [ ] Expose RESTful endpoints (/api/v1/books) returning JSON format.
    - [ ] Implement HTTP status code handling (200 OK, 201 Created, 404 Not Found, 400 Bad Request).
    - [ ] Add OpenAPI / Swagger documentation (/swagger-ui.html).
    - [ ] Prepare backend for potential single-page frontend (React/Vue).

---

## License

This project is open source and available under the MIT License.
