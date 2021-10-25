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

    Scene scene1, scene2, scene3, scene4, scene5, scene6, scene7;

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("My First JavaFX GUI");

//Scene 1

        Button button1= new Button("Go to scene 2");
        button1.setOnAction(e -> primaryStage.setScene(scene2));
        Button button3 = new Button("Submit");
        TextField textField1 = new TextField();
        Text text1 = new Text("");
        AnchorPane layout1 = new AnchorPane();
        layout1.getChildren().addAll(textField1, button1);
        scene1= new Scene(layout1, 1920, 1080);

            FXMLLoader fxmlLoader = new FXMLLoader(YakboksApplication.class.getResource("scene1.fxml"));
            Scene scene1 = new Scene(fxmlLoader.load(), 1920, 1080);
            primaryStage.setTitle("YakBoks!");
            primaryStage.setScene(scene1);
            primaryStage.show();

        Button button= new Button("Go to scene 2");
        button.setOnAction(e -> primaryStage.setScene(scene2));
//Scene 2

        Label label2 = new Label("Name: ");
        Button button2= new Button("Go to scene 1");
        button2.setOnAction(e -> primaryStage.setScene(scene1));
        AnchorPane layout2 = new AnchorPane();
        layout2.getChildren().addAll(label2, button2);
        scene2= new Scene(layout2,1920,1080);


        primaryStage.setScene(scene1);
        primaryStage.show();

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
