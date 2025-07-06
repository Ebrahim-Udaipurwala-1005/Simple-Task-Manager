package de.tum.ise.view;

import de.tum.ise.T10E01ClientApplication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class HomeScene extends Scene {
    public HomeScene(T10E01ClientApplication application) {
        super(new VBox(), 640, 500);

        var title = new Label("Simple Task Management");
        title.setFont(new Font(24));

        var taskButton = new Button("Manage Tasks");
        taskButton.setOnAction(event -> application.showTaskScene());
        taskButton.setPrefSize(150, 30);

        var vBox = new VBox(20, title, taskButton);
        vBox.setAlignment(Pos.CENTER);
        setRoot(vBox);
    }
}