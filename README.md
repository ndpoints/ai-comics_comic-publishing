# Comic Publishing API

## Overview
The Comic Publishing API is designed to manage the publishing and distribution of comics. This microservice provides endpoints to create, retrieve, update, and delete comic publications. It is built using Java Spring Boot and follows the OpenAPI 3.0 specification.

### Purpose
The primary purpose of this microservice is to facilitate the management of comic publications, allowing users to handle publication data efficiently.

### Features
- Retrieve a list of all comic publications.
- Create a new comic publication.
- Retrieve, update, or delete a specific publication by its ID.

### Technical Details
- **API Version**: 1.0.0
- **Base Path**: `/publications`
- **Data Format**: JSON

## Build Instructions

### Spring Boot Application
To build and run the application, follow these steps:
1. Ensure you have Java 11 or higher installed.
2. Clone the repository.
3. Navigate to the project directory.
4. Run `mvn clean install` to build the application and generate a `.jar` file.

### Flyway DB Integration
To set up the database, follow these prerequisites:
- Ensure Docker is installed and running.
- Use the following script to create the database:
  ```sql
  CREATE DATABASE IF NOT EXISTS `publication_db`;
  ```
- To avoid errors with reserved keywords, execute:
  ```sql
  SET sql_mode = 'ANSI_QUOTES';
  ```

## Running Locally

To run the application locally using Docker, follow these steps:
1. Ensure Docker and Docker Compose are installed.
2. Use the provided `docker-compose.yml` file to set up the environment.
3. The `docker-compose` file will:
   - Create a MySQL container.
   - Run `mvn clean install` to build the application and generate a `.jar` file.
   - Build the service image using the Dockerfile.
4. No pre-existing MySQL instance is required as the `docker-compose` will handle the database setup.

### Commands
- To start the application, run:
  ```bash
  docker-compose up --build
  ```
- To stop the application, run:
  ```bash
  docker-compose down
  ```

This README provides a comprehensive guide to understanding, building, and running the Comic Publishing API microservice. Follow the instructions carefully to ensure a smooth setup and operation.