package de.tum.ise.rest;

import de.tum.ise.model.Task;
import de.tum.ise.service.TaskService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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
    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        if (task == null) {
            return ResponseEntity.badRequest().build();
        }
        else {
            return ResponseEntity.ok(taskService.saveTask(task));
        }
    }

    // TODO 1.1: GET /tasks: Get all tasks.
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks() {
        return ResponseEntity.ok(taskService.getAllTasks());
    }
    // TODO 1.1: GET /tasks/{taskId}: Get a single task by its ID.
    @GetMapping("/{taskId}")
    public ResponseEntity<Task> getTaskById(@PathVariable UUID taskId) {
//        return ResponseEntity.ok()
        return taskService.findTaskById(taskId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    // TODO 1.3: PUT /tasks/{taskId}: Update an existing task.

    // TODO 1.4: DELETE /tasks/{taskId}: Delete a task.
}