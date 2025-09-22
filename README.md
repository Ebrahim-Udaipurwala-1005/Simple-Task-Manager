# Simple Task Manager

This project is a simple task manager application that demonstrates the fundamental **CRUD (Create, Read, Update, Delete)** operations. It's built with a client-server architecture using **Spring Boot** for the backend and **JavaFX** for the frontend.

---

## Project Overview

The application is structured into two main components that communicate over a network using **HTTP requests**:

* **Server**: A **Spring Boot** REST API that handles all the business logic. It provides endpoints for creating, retrieving, updating, and deleting tasks.
* **Client**: A **JavaFX GUI** application that interacts with the user. It sends requests to the server's API to manage the tasks displayed in the user interface.

## Features

* **Create Tasks**: Add new tasks with a unique ID generated on the server.
* **View All Tasks**: Retrieve and display all tasks from the server.
* **Update Tasks**: Modify existing tasks and persist the changes to the server.
* **Delete Tasks**: Remove tasks from the system permanently.

---

## How to Run the Application

To get the application up and running, you'll need to start both the server and the client.

1.  **Start the Server**: Navigate to the server directory and run the `bootRun` Gradle task. This will start the Spring Boot application, making the REST API available on `http://localhost:8080`.
    ```bash
    ./gradlew bootRun
    ```

2.  **Start the Client**: After the server is running, navigate to the client directory and run the `run` Gradle task. This will launch the JavaFX GUI, which will automatically connect to the server.
    ```bash
    ./gradlew run
    ```

---

## Technology Stack

* **Backend**: Spring Boot
* **Frontend**: JavaFX
* **Communication**: RESTful API, HTTP
* **Build Tool**: Gradle
