package de.tum.ise.rest;

import de.tum.ise.service.TaskService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
public class TaskResource {

    private final TaskService taskService;

    public TaskResource(TaskService taskService) {
        this.taskService = taskService;
    }

    // TODO: Implement the 5 required REST endpoints here:
    // Use @PostMapping, @GetMapping, @PutMapping, @DeleteMapping, @RequestBody, and @PathVariable.
    // Return ResponseEntity to control the HTTP status codes.

    // TODO 1.1: POST /tasks: Create a new task.
    // TODO 1.1: GET /tasks: Get all tasks.
    // TODO 1.1: GET /tasks/{taskId}: Get a single task by its ID.
    // TODO 1.3: PUT /tasks/{taskId}: Update an existing task.
    // TODO 1.4: DELETE /tasks/{taskId}: Delete a task.
}