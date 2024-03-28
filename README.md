## eShield - Fraud Detection Application
# Overview
This project is a fraud detection application that consists of multiple microservices to handle customer registration, fraud detection, and notification. It leverages various technologies such as Spring Cloud Netflix (Eureka for service discovery, Feign for communication between microservices), Spring Cloud Gateway for API routing, and monitoring tools like Zipkin and Micrometer for distributed tracing and monitoring purposes.

# Features
# Customer Service (CRUD Operations)

. Manages customer data including registration, update, retrieval, and deletion.
. Utilizes Spring Data JPA for database interactions.
. Exposes RESTful APIs for CRUD operations on customer data.

# Fraud Detection Service
. Performs fraud checks based on business logic.
. Communicates internally with the Customer Service using Feign client for fraud checks.
. Stores fraud details along with customer data in a dedicated fraud database.
. Generates a token for notifications if fraud is detected.

# Notification Service
. Sends notifications to customers.
. Stores notification data in a notification database.
. Sends a token with notifications if fraud is detected, otherwise, no token is provided.

# API Gateway (Spring Cloud Gateway)
. Routes incoming requests to the appropriate microservice based on the request path.
. Acts as a single entry point to the system and provides routing, filtering, and load balancing.

# Eureka Server (Service Discovery)
. Registers and manages service instances.
. Provides service discovery and load balancing capabilities to enable communication between microservices.

# Zipkin (Distributed Tracing)
. Collects and analyzes trace data for requests that span multiple microservices.
. Provides insights into the performance and dependencies of services in the system.

# Micrometer (Monitoring)
. Collects metrics and performance data from microservices.
. Enables monitoring and visualization of application performance and health.

# Technologies Used
=> Spring Boot: For building microservices.
=> Spring Cloud Netflix: For service discovery (Eureka), client-side load balancing (Ribbon), and declarative REST client (Feign).
=> Spring Cloud Gateway: For API routing and filtering.
=> Spring Data JPA: For database interactions.
=> Zipkin: For distributed tracing.
=> Micrometer: For monitoring and metrics collection.
=> Database: Used to store customer data, fraud details, and notification data.
=> Docker: For containerization of microservices.
=> GitHub: For version control and collaboration.

# Architecture Overview
The architecture of the fraud detection system is based on microservices, where each microservice is responsible for a specific functionality. Service communication is handled through RESTful APIs, and service discovery and load balancing are facilitated by Eureka Server. The API Gateway provides a unified entry point to the system, and monitoring and tracing are enabled through Zipkin and Micrometer.
