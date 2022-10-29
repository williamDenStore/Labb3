package com.william_k.labb3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PaintApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PaintApplication.class.getResource("paint-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        //stage.setMaximized(true);
        stage.setResizable(false);
        stage.setTitle("W-Paint");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}