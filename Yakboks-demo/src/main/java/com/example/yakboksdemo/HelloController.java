package com.example.yakboksdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;

import java.io.IOException;

public class HelloController {
    @FXML private TextField input;
    @FXML private Label output;
    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        //output.setText(input.getText());
        System.out.println(input.getText());
        Parent scene_2_parent= FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene scene2=new Scene(scene_2_parent);
    }
}