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

public class VoteListController implements Initializable {
    @FXML
    public Label labelUsername;



    @FXML

    public void onReturnClick(ActionEvent event) throws IOException {
        Parent scene_3_parent = FXMLLoader.load(getClass().getResource("LobbyMenu.fxml"));
        Scene scene3 = new Scene(scene_3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene3);
        app_stage.show();
    }

    public void onExitClick(ActionEvent event) {
        System.exit(1);
    }

    public void onNewCardClick(ActionEvent event) throws IOException {
        Parent scene_5_parent = FXMLLoader.load(getClass().getResource("NewCard.fxml"));
        Scene scene5 = new Scene(scene_5_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene5);
        app_stage.show();
    }


    public void onMainMenuClick(ActionEvent event) throws IOException {
        Parent scene_2_parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene2 = new Scene(scene_2_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
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

