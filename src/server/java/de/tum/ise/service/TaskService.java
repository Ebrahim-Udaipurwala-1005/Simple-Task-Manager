package de.tum.ise.service;

import de.tum.ise.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();

    public List<Task> getAllTasks() {
        // TODO 1.2: Return a copy of the tasks list to prevent modification from outside.
        return null;
    }

    public Optional<Task> findTaskById(UUID taskId) {
        // TODO 1.1: Find and return a task by its ID using a stream.
        return Optional.empty();
    }

    public Task saveTask(Task task) {
        // TODO 1.1: Implement the logic to save a task.
        // If the task's ID is null, it's a new task. Generate a new UUID, set it, and add the task to the list.
        // If the task's ID is not null, it's an update. Find the existing task and update its properties.
        return null;
    }

    public void deleteTask(UUID taskId) {
        // TODO 1.4: Remove the task with the given ID from the list.
    }
}