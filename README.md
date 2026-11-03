# Libra - Book Management & Tracking System

A Java web application built with Spring Boot and Thymeleaf to track personal books, reading status, and ratings.

## Features

- **User Authentication:** Multi-user security system with user registration, encrypted passwords (BCrypt), session management, and secure logout.
- **Personal Book Catalog:** Manage user-specific book collections.
- **Clean User Interface:** Fully responsive web interface rendered dynamically with Thymeleaf.

## Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 3.x, Spring Security
- **Database & Persistence:** Spring Data JPA, H2 Database (In-Memory)
- **Frontend:** Thymeleaf, HTML5, CSS3
- **Containerization & Deployment:** Docker, Render

## Live Demo

The application is deployed live on Render:
- **Live URL:** https://libra-4q6r.onrender.com

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 21 or higher
- Git

### Running Locally

1. Clone the repository:
   git clone https://github.com/your-username/libra.git
   cd libra

2. Build and run the application:
    - On Linux/macOS:
      ./mvnw spring-boot:run
    - On Windows:
      mvnw.cmd spring-boot:run

3. Access the application:
   Navigate to http://localhost:8080/login in your browser.

### Running with Docker

1. Build and run with Docker:
   docker build -t libra-app .
   docker run -p 8080:8080 libra-app

## License

This project is open source and available under the MIT License.