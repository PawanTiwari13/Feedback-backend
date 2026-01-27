# Feedback Management Backend

## Description
A role-based feedback management backend built using **Java 17** and **Spring Boot**, designed to handle structured academic feedback workflows with **strict Role-Based Access Control (RBAC)**.

The system enforces clear separation of responsibilities between **Admin**, **Course Coordinator**, **Teacher**, and **Student** roles.  
Security is implemented using **JWT-based authentication**, service-level authorization checks, and database constraints to ensure controlled feedback creation, secure submission, and anonymized analytics.

---

## Tech Stack
- Java 17  
- Spring Boot 3.x  
- Spring Security  
- JWT Authentication  
- JPA / Hibernate  
- Maven  
- REST APIs  

---

## Features
- JWT-based authentication and authorization
- Strict role-based access control (RBAC)
- Batch- and subject-scoped feedback forms
- Write-once feedback submission enforcement
- Aggregated and anonymized analytics for teachers
- Clear separation of authentication, business logic, and analytics
- Feature-based modular backend architecture

---

## Roles & Responsibilities

### Admin
- Create courses and subjects
- Assign teachers to subjects
- Manages academic structure only (non-operational)

### Course Coordinator
- Create and manage batches
- Assign students to batches
- Enroll batches into courses
- Create, open, close, and track feedback forms
- Monitor feedback completion status (counts only)

### Student
- View assigned feedback forms
- Submit feedback (one-time submission enforced)
- View personal feedback submission history

### Teacher
- View aggregated and anonymized feedback analytics
- Access limited strictly to subjects they teach
- No access to individual feedback responses

---

## Feedback Workflow
1. Admin creates courses and assigns teachers to subjects  
2. Course Coordinator creates batches and enrolls them into courses  
3. Course Coordinator creates feedback forms scoped to **course + subject + batch**  
4. Students submit feedback (write-once)  
5. Teachers view aggregated analytics only  

At no point can any role view individual feedback responses.

---

## Domain Model

### Core Entities
- User  
- Role  
- UserRole  
- Course  
- Subject  
- Batch  
- CourseBatch  
- BatchStudent  
- FeedbackForm  
- FeedbackQuestion  
- FeedbackResponse  
- FeedbackAnswer  

Analytics data is derived dynamically and not stored as separate entities.

---

## Architecture Overview
- Feature-based modular structure:
  - `auth`
  - `course`
  - `batch`
  - `feedback`
  - `analytics`
- DTO-based API contracts
- Stateless authentication using JWT
- RBAC enforced at controller, service, and database layers
- Backend acts as the single source of truth for authorization

---

## Project Structure
 com.pawan.feedback.system
 
├── entity

├── dto

├── serivce

├── controller

├── repository

└── config

Each module follows:
- Controller  
- Service  
- Repository  
- DTO  
- Entity  

---

## Getting Started

### Prerequisites
- Java 17+
- Maven
- MySQL / PostgreSQL (or any supported relational database)

### Run Locally
```bash
# Clone repository
git clone <repository-url>

# Navigate to backend
cd backend

# Build the project
mvn clean install

# Run the application
mvn spring-boot:run

