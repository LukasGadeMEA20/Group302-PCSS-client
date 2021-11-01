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

public class NewCardController implements Initializable {

    @FXML
    public Label labelUsername;



    @FXML

    public void onHelloButtonClick8(ActionEvent event) throws IOException {
        Parent scene_6_parent = FXMLLoader.load(getClass().getResource("EnterCardText.fxml"));
        Scene scene6 = new Scene(scene_6_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene6);
        app_stage.show();
    }

    public void onHelloButtonClick3(ActionEvent event) {
        System.exit(1);
    }

    public void onHelloButtonClick9(ActionEvent event) throws IOException {
        Parent scene_7_parent = FXMLLoader.load(getClass().getResource("VoteList.fxml"));
        Scene scene7 = new Scene(scene_7_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene7);
        app_stage.show();
    }


    public void onHelloButtonClick10(ActionEvent event) throws IOException {
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

