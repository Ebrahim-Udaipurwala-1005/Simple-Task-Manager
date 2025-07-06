package de.tum.ise;

import de.tum.ise.controller.TaskController;
import de.tum.ise.view.HomeScene;
import de.tum.ise.view.TaskScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class T10E01ClientApplication extends Application {
    private final TaskController taskController = new TaskController();
    private Stage stage;

    @Override
    public void start(Stage primaryStage) {
        this.stage = primaryStage;
        primaryStage.setTitle("Simple Task Manager");
        showHomeScene();
        primaryStage.show();
    }

    public void showHomeScene() {
        stage.setScene(new HomeScene(this));
    }

    public void showTaskScene() {
        stage.setScene(new TaskScene(taskController, this));
    }

    public Stage getStage() {
        return stage;
    }
}