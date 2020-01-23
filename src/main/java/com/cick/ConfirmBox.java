package com.cick;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {

    static boolean answer;

    public static boolean display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);

        Label label = new Label();
        label.setText(message);

        Button button_1 = new Button("Yes");
        Button button_2 = new Button("No");

        button_1.setOnAction(event -> {
            answer = true;
            window.close();
        });
        button_2.setOnAction(event -> {
            answer = false;
            window.close();
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, button_1, button_2);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout, 320, 100);
        window.setResizable(false);
        window.setX(515);
        window.setY(250);
        window.setAlwaysOnTop(true);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}