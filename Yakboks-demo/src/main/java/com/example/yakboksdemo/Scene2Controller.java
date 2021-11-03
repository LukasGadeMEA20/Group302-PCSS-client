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

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Scene2Controller implements Initializable {
    @FXML
    public Label labelUsername;



    @FXML

    public void onJoinGameClick(ActionEvent event) throws IOException {


        Parent scene_9_parent = FXMLLoader.load(getClass().getResource("scene9.fxml"));
        Scene scene9 = new Scene(scene_9_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene9);
        app_stage.show();
    }

    public void onExitGameClick(ActionEvent event) {
        System.exit(1);
    }

    public void onHowToPlayClick(ActionEvent event) throws IOException {
        Parent scene_4_parent = FXMLLoader.load(getClass().getResource("scene4.fxml"));
        Scene scene4 = new Scene(scene_4_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene4);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        if (Data.username.equals("")){
            labelUsername.setText("");
        }
        else{
            labelUsername.setText(Data.username);

        }
    }

    }


