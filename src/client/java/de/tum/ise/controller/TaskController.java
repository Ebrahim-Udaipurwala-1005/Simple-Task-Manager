package de.tum.ise.controller;

import de.tum.ise.model.Task;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TaskController {

    // TODO 2.1: Add attributes for the WebClient and a local list of tasks.
    // Then, implement the constructor to initialize them.

    public TaskController() {
        // TODO: 2.1
    }

    public void getAllTasks(Consumer<List<Task>> tasksConsumer) {
        // TODO 2.1: Make a GET request to /tasks.
        // On success, clear the local list, add all received tasks, and call the consumer.
    }

    public void createTask(Task task, Consumer<List<Task>> tasksConsumer) {
        // TODO 2.2: Make a POST request to /tasks with the new task in the body.
        // On success, add the returned task (with its new ID) to the local list and call the consumer.
    }

    public void updateTask(Task task, Consumer<List<Task>> tasksConsumer) {
        // TODO 2.3: Make a PUT request to /tasks/{taskId} with the updated task in the body.
        // On success, replace the old task in the local list with the updated one and call the consumer.
    }

    public void deleteTask(Task task, Consumer<List<Task>> tasksConsumer) {
        // TODO 2.4: Make a DELETE request to /tasks/{taskId}.
        // On success, remove the task from the local list and call the consumer.
    }
}