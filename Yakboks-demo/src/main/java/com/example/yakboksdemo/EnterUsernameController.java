package com.example.yakboksdemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterUsernameController implements Initializable{
    @FXML
    public TextField input;
    public Label subtitle;

    //Makes an event so that each time you click the button, it will switch to the other scene/page
    public void onContinueClick(ActionEvent event) throws IOException {
        if (input.getText().isEmpty()) { // makes sure the user enters a username by telling the user to type in a username if it is empty
            input.setPromptText("Please type in a username");
            subtitle.setTextFill(Color.web("#FF0000"));
        }
        else { // Else it will add the username to the programs data and load the next scene.
            Data.username = input.getText(); // Add to connect to server screen.

            Parent scene_1_parent = FXMLLoader.load(getClass().getResource("EnterIP.fxml"));
            Scene scene1 = new Scene(scene_1_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene1);
            app_stage.show();
        }
    }

    // Codes which gets run when the controller gets initialized
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Adds a listener to text field, which checks if it gets changed.
        // This makes sure the username does not extend a specific value.
        input.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(final ObservableValue<? extends String> ov, final String oldValue, final String newValue) {
                int maxValue = 12;
                // Checks if the length is bigger than the max value allowed
                if (input.getText().length() > maxValue) {
                    // sets the text in the input by taking the string from 0 to 12 index of the string object.
                    String s = input.getText().substring(0, maxValue);
                    input.setText(s);
                }
            }
        });
    }
}
