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
    private final WebClient webClient;
    private List<Task> tasks;

    public TaskController() {
        // TODO: 2.1
        webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
        tasks = new ArrayList<>();
    }

    public void getAllTasks(Consumer<List<Task>> tasksConsumer) {
        // TODO 2.1: Make a GET request to /tasks.
        // On success, clear the local list, add all received tasks, and call the consumer.
        webClient.get()
                .uri("/tasks")
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Task>>() {})
                .onErrorStop()
                .subscribe(newTasks -> {
                    tasks.clear();
                    tasks.addAll(newTasks);
                    tasksConsumer.accept(tasks);
                });
    }

    public void createTask(Task task, Consumer<List<Task>> tasksConsumer) {
        // TODO 2.2: Make a POST request to /tasks with the new task in the body.
        // On success, add the returned task (with its new ID) to the local list and call the consumer.
        webClient.post()
                .uri("/tasks")
                .bodyValue(task)
                .retrieve()
                .bodyToMono(Task.class)
                .onErrorStop()
                .subscribe(newTask -> {
                    tasks.add(newTask);
                    tasksConsumer.accept(new ArrayList<>(tasks));
        });
    }

    public void updateTask(Task task, Consumer<List<Task>> tasksConsumer) {
        // TODO 2.3: Make a PUT request to /tasks/{taskId} with the updated task in the body.
        // On success, replace the old task in the local list with the updated one and call the consumer.
        webClient.put()
                .uri("/tasks/" + task.getId())
                .bodyValue(task)
                .retrieve()
                .bodyToMono(Task.class)
                .onErrorStop()
                .subscribe(newTask -> {
                    tasks.replaceAll(t -> t.getId().equals(task.getId()) ? newTask : t);
                });
    }

    public void deleteTask(Task task, Consumer<List<Task>> tasksConsumer) {
        // TODO 2.4: Make a DELETE request to /tasks/{taskId}.
        // On success, remove the task from the local list and call the consumer.
        webClient.delete()
                .uri("/tasks/" + task.getId())
                .retrieve()
                .toBodilessEntity()
                .onErrorStop()
                .subscribe(v -> {
                    tasks.removeIf(t -> t.getId().equals(task.getId()));
                    tasksConsumer.accept(new ArrayList<>(tasks));
                });
    }
}