# Simple Task Manager

Developed as part of the **INHN0006 Introduction to Software Engineering** course under the guidance of Prof. Dr. Stefan Wagner, this project, "Simple Task Manager," is designed to provide hands-on experience with fundamental software engineering concepts. The application follows a classic client-server model to demonstrate the four essential **CRUD (Create, Read, Update, Delete)** operations. The server-side is a robust RESTful API built with **Spring Boot**, while the client-side is a dynamic GUI application implemented in **JavaFX**. This architecture highlights the principles of layered design and network communication in a practical context.

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
