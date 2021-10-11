package com.example.yakboksdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class YakboksApplication extends Application {

    Scene scene1, scene2;

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("My First JavaFX GUI");

//Scene 1

        Label label1= new Label("This is the first scene");
        Button button1= new Button("Go to scene 2");
        button1.setOnAction(e -> primaryStage.setScene(scene2));
        VBox layout1 = new VBox(20);
        layout1.getChildren().addAll(label1, button1);
        scene1= new Scene(layout1, 300, 250);

            FXMLLoader fxmlLoader = new FXMLLoader(YakboksApplication.class.getResource("scene1.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 320, 240);
            primaryStage.setTitle("YakBoks!");
            primaryStage.setScene(scene1);
            primaryStage.show();

        Button button= new Button("Go to scene 2");
        button.setOnAction(e -> primaryStage.setScene(scene2));
//Scene 2

        Label label2= new Label("This is the second scene");
        Button button2= new Button("Go to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(scene1));
        VBox layout2= new VBox(20);
        layout2.getChildren().addAll(label2, button2);
        scene2= new Scene(layout2,300,250);


        primaryStage.setScene(scene1);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}
