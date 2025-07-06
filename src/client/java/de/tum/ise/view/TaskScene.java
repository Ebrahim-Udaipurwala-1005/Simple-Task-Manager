package de.tum.ise.view;

import de.tum.ise.T10E01ClientApplication;
import de.tum.ise.controller.TaskController;
import de.tum.ise.model.Task;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Popup;

import java.util.List;

public class TaskScene extends Scene {
    private final TaskController taskController;
    private final T10E01ClientApplication application;
    private final ObservableList<Task> taskList;

    public TaskScene(TaskController taskController, T10E01ClientApplication application) {
        super(new VBox(), 800, 600);
        this.taskController = taskController;
        this.application = application;
        this.taskList = FXCollections.observableArrayList();

        var table = createTable();
        var vBox = new VBox(10, table, createButtonBox());
        vBox.setPadding(new Insets(10));
        vBox.setAlignment(Pos.CENTER);
        setRoot(vBox);

        // Initially load all tasks
        taskController.getAllTasks(this::setTasks);
    }

    private TableView<Task> createTable() {
        var table = new TableView<>(taskList);
        table.setRowFactory(tv -> {
            TableRow<Task> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (!row.isEmpty() && event.getClickCount() == 2) {
                    showPopup(row.getItem());
                }
            });
            return row;
        });

        var titleColumn = new TableColumn<Task, String>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleColumn.setPrefWidth(250);

        var descriptionColumn = new TableColumn<Task, String>("Description");
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
        descriptionColumn.setPrefWidth(350);

        var completedColumn = new TableColumn<Task, Boolean>("Completed");
        completedColumn.setCellValueFactory(new PropertyValueFactory<>("completed"));
        completedColumn.setPrefWidth(100);

        table.getColumns().addAll(titleColumn, descriptionColumn, completedColumn);
        return table;
    }

    private HBox createButtonBox() {
        var backButton = new Button("Back");
        backButton.setOnAction(event -> application.showHomeScene());

        var addButton = new Button("Add Task");
        addButton.setOnAction(event -> showPopup(null));

        var refreshButton = new Button("Refresh");
        refreshButton.setOnAction(event -> taskController.getAllTasks(this::setTasks));

        var buttonBox = new HBox(10, backButton, addButton, refreshButton);
        buttonBox.setAlignment(Pos.CENTER);
        return buttonBox;
    }

    private void showPopup(Task task) {
        var popup = new Popup();
        var titleField = new TextField();
        titleField.setPromptText("Task Title");
        var descriptionField = new TextField();
        descriptionField.setPromptText("Description");
        var completedCheckbox = new CheckBox("Completed");

        if (task != null) {
            titleField.setText(task.getTitle());
            descriptionField.setText(task.getDescription());
            completedCheckbox.setSelected(task.isCompleted());
        }

        var saveButton = new Button("Save");
        saveButton.setOnAction(event -> {
            var newTask = task != null ? task : new Task();
            newTask.setTitle(titleField.getText());
            newTask.setDescription(descriptionField.getText());
            newTask.setCompleted(completedCheckbox.isSelected());
            if (task == null) {
                taskController.createTask(newTask, this::setTasks);
            } else {
                taskController.updateTask(newTask, this::setTasks);
            }
            popup.hide();
        });

        var cancelButton = new Button("Cancel");
        cancelButton.setOnAction(event -> popup.hide());

        var deleteButton = new Button("Delete");
        deleteButton.setTextFill(Color.RED);
        deleteButton.setOnAction(event -> {
            if (task != null) {
                taskController.deleteTask(task, this::setTasks);
            }
            popup.hide();
        });

        var buttonBar = new HBox(10, saveButton, cancelButton);
        buttonBar.setAlignment(Pos.CENTER);
        if (task != null) {
            buttonBar.getChildren().add(deleteButton);
        }

        var vBox = new VBox(10, new Label(task == null ? "Add New Task" : "Edit Task"),
                titleField, descriptionField, completedCheckbox, buttonBar);
        vBox.setAlignment(Pos.CENTER);
        vBox.setBackground(new Background(new BackgroundFill(Color.WHITESMOKE, new CornerRadii(5), null)));
        vBox.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), new BorderWidths(1))));
        vBox.setPrefWidth(400);
        vBox.setPadding(new Insets(15));
        popup.getContent().add(vBox);
        popup.show(application.getStage());
        popup.centerOnScreen();
    }

    private void setTasks(List<Task> tasks) {
        Platform.runLater(() -> taskList.setAll(tasks));
    }
}