package com.example.yakboksdemo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class YakboksApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Loads the first page for the program.
        FXMLLoader fxmlLoader = new FXMLLoader(YakboksApplication.class.getResource("EnterUsername.fxml"));
        Scene scene1 = new Scene(fxmlLoader.load(), 1920, 1080); // Set to 1920x1080, because we did not think of making it dynamic for different screen sizes and was deemed to much work to change.
        primaryStage.setTitle("YakBoks!"); // Gives the program a title so it is easy to find in the navigation tray.
        primaryStage.setScene(scene1);
        primaryStage.show();

        // Adds a listener to the program, which acts when the user clicks escape.
        // Closes the program.
        primaryStage.addEventHandler(KeyEvent.KEY_RELEASED, (KeyEvent event) -> {
            if (KeyCode.ESCAPE == event.getCode()) {
                System.exit(1); //primaryStage.close(); can also be used, but we found System.exit(1); to be a tiny bit faster.
            }
        });

        // Sets the globally used stage static variable to be the current stage, so the program knows what stage it is working with.
        Data.stage = primaryStage;
    }

    // Launches the program.
    public static void main(String[] args) {
        launch(args);
    }

}
