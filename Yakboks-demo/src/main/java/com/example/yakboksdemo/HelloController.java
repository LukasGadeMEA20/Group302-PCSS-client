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
    public Label label2;

    //Makes an event so that each time you click the button, it will switch to the other scene/page

    @FXML
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        Parent scene_2_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene scene2 = new Scene(scene_2_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    public void onHelloButtonClick2(ActionEvent event) throws IOException {
        Parent scene_1_parent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene1 = new Scene(scene_1_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene1);
        app_stage.show();
    }

    public void onHelloButtonClick3(ActionEvent event) {
        System.exit(1);
    }

    public void onHelloButtonClick4(ActionEvent event) {
        String name = input.getText();
        System.out.println(name);
        label2.setText(name);
    }

    public void onHelloButtonClick5(ActionEvent event) throws IOException {
        Parent scene_3_parent = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        Scene scene3 = new Scene(scene_3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene3);
        app_stage.show();
    }

    public void onHelloButtonClick6(ActionEvent event) throws IOException {
        Parent scene_4_parent = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        Scene scene4 = new Scene(scene_4_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene4);
        app_stage.show();
    }

    public void onHelloButtonClick7(ActionEvent event) throws IOException {
        Parent scene_5_parent = FXMLLoader.load(getClass().getResource("scene5.fxml"));
        Scene scene5 = new Scene(scene_5_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene5);
        app_stage.show();
    }

    public void onHelloButtonClick8(ActionEvent event) throws IOException {
        Parent scene_6_parent = FXMLLoader.load(getClass().getResource("scene6.fxml"));
        Scene scene6 = new Scene(scene_6_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene6);
        app_stage.show();
    }

    public void onHelloButtonClick9(ActionEvent event) throws IOException {
        Parent scene_7_parent = FXMLLoader.load(getClass().getResource("scene7.fxml"));
        Scene scene7 = new Scene(scene_7_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene7);
        app_stage.show();
    }
}






//bla