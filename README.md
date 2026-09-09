Tasks API

## Description

This project is a REST API that allows users to add, view, rename and delete specific Tasks

## Technologies

- Java 25
- Spring Boot
- Maven
- Spring Data JPA
- PostgreSQL
- Hibernate

## Architecture

The API follows a layered architecture:

- Tarea: This is the model, a Tarea represents the task entity
- TareasController: A controller that receives the HTTP requests and delegates operations to the service layer
- TareasService: Contains the business logic of the API, manages exceptions and coordinates operations between the controller and repository
- TareasRepository: Connects to the database through Spring Data JPA and Hibernate

## Migration from ArrayList to PostgreSQL

Task API was originally made as a practice project and had an ArrayList as a Repository of tasks, it had all the methods like findById done by hand, but then was migrated to PostgreSQL and JPA by integrating it in TareasRepository

Before JPA:
Controller -> Service -> Repository -> ArrayList

After JPA:
Controller -> Service -> Repository -> JPA/Hibernate -> PostgreSQL

## Prerequisites

- Java 25
- PostgreSQL
- Maven

## How to run

- Clone the code
- Create a database in PostgreSQL named tareas_bd
- Configure the database credentials in application.properties
- Run the Spring boot application

## Endpoints

| Method | Endpoint       | Description       |
| ------ | -------------- | ----------------- |
| GET    | `/tareas`      | Get all tasks     |
| GET    | `/tareas/{id}` | Get a task by ID  |
| POST   | `/tareas`      | Create a new task |
| PUT    | `/tareas/{id}` | Update a task     |
| DELETE | `/tareas/{id}` | Delete a task     |

## Example

A JSON body is required to create a task.

`POST /tareas`

```json
{
  "nombre": "Study Spring Boot"
}
```

## About the project

This project was a great practice to study and understand a lot of concepts about backend, Java, Spring Boot, JPA, etc. This might be the starting point of my career
