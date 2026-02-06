# Spring Security JWT Project

## About the Project
This project is a simple **Spring Boot application** that demonstrates how **JWT (JSON Web Token)** is used with **Spring Security** to secure REST APIs.

Instead of using server-side sessions, the application uses JWT tokens to authenticate users. Once a user logs in successfully, a token is generated and must be sent with every secured request.

The main goal of this project is to understand how Spring Security works with JWT, including filters, authentication flow, and request validation.

---

## Technologies Used
- Java  
- Spring Boot  
- Spring Security  
- JWT  
- Spring Data JPA  
- Maven  

---

## How Authentication Works
1. The user sends login details to the login API.  
2. If the credentials are valid, a JWT token is generated.  
3. The token is returned to the client.  
4. For secured APIs, the client must send the token in the request header.  
5. A JWT filter checks the token and allows access if it is valid.

---

## API Endpoints

### Authentication
| Method | Endpoint | Description |
|------|----------|-------------|
| POST | `/auth/login` | Login and receive JWT token |

### Secured API
| Method | Endpoint | Description |
|------|----------|-------------|
| GET | `/hello` | Accessible only with a valid JWT |

---

## Security Details
- JWT-based authentication  
- Stateless session management  
- CSRF disabled for REST APIs  
- Custom JWT filter for request validation  
- Passwords encrypted using BCrypt  

---

## Running the Application
mvn clean install
mvn spring-boot:run



The application runs on:

http://localhost:8080


What I Learned :

Basics of Spring Security

How JWT tokens are generated and validated

How filters work in Spring Security

Securing REST APIs without sessions

mvn clean install
mvn spring-boot:run
