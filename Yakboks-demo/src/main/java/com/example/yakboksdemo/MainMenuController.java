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

public class MainMenuController implements Initializable {
    @FXML
    public Label labelUsername;

    @FXML
    public void onJoinGameClick(ActionEvent event) throws IOException {

        Parent scene_3_parent = FXMLLoader.load(getClass().getResource("EnterIP.fxml"));
        Scene scene3 = new Scene(scene_3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene3);
        app_stage.show();
    }

    public void onExitGameClick(ActionEvent event) {
        System.exit(1);
    }

    public void onHowToPlayClick(ActionEvent event) throws IOException {
        Parent scene_4_parent = FXMLLoader.load(getClass().getResource("HowToPlay.fxml"));
        Scene scene4 = new Scene(scene_4_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene4);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelUsername.setText(Data.username);
    }
}


