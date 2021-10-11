package com.example.yakboksdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Node;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HelloController {
    @FXML
    private TextField input;
    @FXML
    private Label output;

    //Makes an event so that each time you click the button, it will switch to the other scene/page

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        System.out.println(input.getText());
        Parent scene_2_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene scene2 = new Scene(scene_2_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    public void onHelloButtonClick2(ActionEvent event) throws IOException {
        System.out.println(input.getText());
        Parent scene_1_parent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene1 = new Scene(scene_1_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene1);
        app_stage.show();
    }
}