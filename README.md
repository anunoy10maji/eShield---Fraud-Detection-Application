## eShield - Fraud Detection Application

# Overview
This project is a Fraud Detection Application designed to provide fraud detection services for customer registration. It consists of several microservices built using Spring Boot and Spring Cloud, and utilizes various technologies such as Eureka for service discovery, Feign for communication between microservices, and Zipkin for distributed tracing.

# Features
# Customer Service (CRUD Operations)
. Allows CRUD operations for managing customer data.
. Provides RESTful endpoints for creating, reading, updating, and deleting customer records.
![Non_Fraud_Case](https://github.com/anunoy10maji/eShield---Fraud-Detection-Application/assets/86963404/dff92f4e-e898-4bbe-9642-677fb67aa567)

# Fraud Detection Service
. Performs fraud checks based on business logic upon customer registration.
. Communicates with other microservices via Feign clients.
. Stores fraud details along with customer information in the fraud database.
# API Gateway
. Utilizes an API Gateway for routing requests to appropriate microservices.
. Provides a single entry point for client applications to access various services.
# Eureka Server and Service Discovery
. Implements Eureka server for service discovery and registration.
. Enables dynamic service registration and load balancing across multiple instances.
# Distributed Tracing and Monitoring
. Integrates Zipkin for distributed tracing to monitor and debug service calls.
. Utilizes Micrometer for collecting and publishing metrics for monitoring and analysis.

## Architecture
The architecture of the Fraud Detection Application is based on microservices principles, with each microservice handling a specific set of responsibilities.

# Customer Service: Manages customer data and exposes CRUD endpoints.
# Fraud Detection Service: Performs fraud checks and stores fraud details.
# API Gateway: Routes requests to appropriate microservices and handles client interactions.
# Eureka Server: Provides service discovery and registration for dynamic scaling.
# Zipkin: Collects and traces distributed call information for monitoring and debugging.
# Micrometer: Collects metrics data for monitoring and analysis.

# Technologies Used
. Spring Boot
. Spring Cloud (Feign Client)
. Netflix Eureka (API Gateway)
. Zipkin (Distributed Tracing)
. Micrometer (Metrics Collection)
. Java
