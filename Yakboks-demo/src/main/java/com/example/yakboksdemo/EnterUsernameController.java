package com.example.yakboksdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterUsernameController {
    @FXML
    public TextField input;

    @FXML
    public Label label3;

    @FXML
    public boolean Login;

    @FXML
    public Label label4;


    //Makes an event so that each time you click the button, it will switch to the other scene/page
    @FXML
    //skifter kun side hvis login er true.
    protected void onContinueClick(ActionEvent event) throws IOException {
        if (Login) {
            Parent scene_2_parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene2 = new Scene(scene_2_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene2);
            app_stage.show();
        }
        else{
            label3.setText("Please type in a username");
        }
    }

    public void onCheckUsernameClick(ActionEvent event) throws IOException {
        if (input.getText().isEmpty()) {
            label3.setText("Please type in a username");
            Login=false;
        }
        else {
            Login=true;
            label3.setText("");
            label4.setText("username valid");
            Data.username = input.getText(); // Add to connect to server screen.
            //continue1.setVisible(true);
            Parent scene_1_parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
            Scene scene1 = new Scene(scene_1_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene1);
            app_stage.show();
        }
    }
}
