# Libra - Book Management & Tracking System

A Java web application built with Spring Boot and Thymeleaf to track personal books, reading status, and ratings.

---

## Features

- **Book Catalog:** Add new books with title, author, publication year, and genre.
- **Reading Tracker:** Mark books as finished or unread and assign ratings (1–5 stars).
- **Library Actions:** Delete books or update ratings directly from the UI.
- **User Interface:** Clean HTML/CSS interface rendered with Thymeleaf.

---

## Tech Stack

- **Language:** Java 25
- **Framework:** Spring Boot 3.2.4
- **Database & ORM:** Spring Data JPA, H2 (for development), and Flyway (for schema migrations)
- **Frontend:** Thymeleaf + HTML/CSS
- **Build Tool:** Maven

---

## Getting Started

### Prerequisites
- JDK 17 or higher (running on Java 25)
- Maven (included via ./mvnw)

### Running the Application

1. Clone the repository:
   git clone [https://github.com/your-username/libra.git](https://github.com/your-username/libra.git)
   cd libra

2. Run using Maven:
   ./mvnw spring-boot:run

3. Open in browser:
   Navigate to http://localhost:8080/books

---

## Roadmap & Progress

- [x] **Phase 1: Core MVC Setup**
    - [x] Create Book domain model with validation.
    - [x] Implement in-memory BookCollection service (ArrayList).
    - [x] Create BookController for web routing (@GetMapping, @PostMapping).
    - [x] Render UI using Thymeleaf (books.html).

- [x] **Phase 2: Database Integration (Spring Data JPA & SQL)**
    - [x] Add Spring Data JPA and H2 database dependencies.
    - [x] Annotate Book as a JPA @Entity.
    - [x] Replace ArrayList with Spring Data BookRepository.
    - [x] Implement Flyway database migrations (V1__create_book_table.sql).

- [ ] **Phase 3: User Authentication & Security (Spring Security)**
    - [ ] Add Spring Security dependency.
    - [ ] Create User and Role entities with hashed passwords (BCrypt).
    - [ ] Add login and registration pages.
    - [ ] Link book collections to individual user accounts.

- [ ] **Phase 4: Database Migration (PostgreSQL / MySQL)**
    - [ ] Set up a production-ready database (PostgreSQL or MySQL via Docker).
    - [ ] Update application.properties and database drivers.
    - [ ] Adapt Flyway scripts for the production database.

---

## License

This project is open source and available under the MIT License.