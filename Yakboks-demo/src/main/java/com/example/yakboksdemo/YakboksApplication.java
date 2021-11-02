package com.example.yakboksdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.event.KeyListener;
import java.io.IOException;

public class YakboksApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

            FXMLLoader fxmlLoader = new FXMLLoader(YakboksApplication.class.getResource("scene1.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 1920, 1080);
            primaryStage.setTitle("YakBoks!");
            primaryStage.setScene(scene1);
            primaryStage.show();

            Data.veryDumbCode = primaryStage;

            //Closes the window with esc button
            primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                primaryStage.close();
            }
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

}
