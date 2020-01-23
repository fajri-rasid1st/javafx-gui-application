package com.cick;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputWrongAlert {
    public static void display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);

        Button button = new Button("Continue");
        button.setOnAction(event -> {
            window.close();
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(label, button);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 300, 110);
        window.setResizable(false);
        window.setX(535);
        window.setY(280);
        window.setAlwaysOnTop(true);
        window.setScene(scene);
        window.showAndWait();

    }
}