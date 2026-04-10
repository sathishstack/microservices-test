# microservices-test

A sample project for testing Java Spring Boot microservices. 

## Services Overview

This project consists of an API Gateway and four distinct microservices. Each service connects to its own in-memory H2 database.

| Service Name | Port | Description / Dependencies |
|---|---|---|
| **API Gateway** | `8080` | Routes requests to backend services. Depends on all services. |
| **Order Service** | `8081` | Manages orders (`orders-db`). Depends on Inventory, Payment, and Notification services. |
| **Inventory Service**| `8082` | Manages stock/inventory (`inventory-db`). |
| **Payment Service** | `8083` | Handles payments (`payments-db`). |
| **Notification Service** | `8084` | Sends out notifications (`notifications-db`). |

## Running the Application

You can run the full suite of microservices using Docker Compose:

```bash
docker-compose up --build
```

## References

Chat GPT convo: [link](https://chatgpt.com/c/69d8dfad-338c-8324-8328-14638c66ae05)
