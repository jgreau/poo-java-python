package com.duoc.javafxbase;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Hola, JavaFX!");
        Scene scene = new Scene(label, 320, 240);

        stage.setTitle("javafx-base");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
