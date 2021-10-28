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

public class Scene1Controller implements Initializable {
    @FXML
    public TextField input;
    @FXML
    public Label labelUsername;
    @FXML
    public Label label3;
    @FXML
    public boolean Login;
    @FXML
    public Label label4;
    @FXML
    public Button continue1;


    //Makes an event so that each time you click the button, it will switch to the other scene/page

    @FXML

    //skifter kun side hvis login er true.
    protected void onHelloButtonClick(ActionEvent event) throws IOException {
        if (Login) {
            Parent scene_2_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
            Scene scene2 = new Scene(scene_2_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene2);
            app_stage.show();
        }
        else{
            label3.setText("Please type in a username");
        }

    }


    //samme kode igennem til at skifte side.
    public void onHelloButtonClick2(ActionEvent event) throws IOException {
        Parent scene_1_parent = FXMLLoader.load(getClass().getResource("scene1.fxml"));
        Scene scene1 = new Scene(scene_1_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene1);
        app_stage.show();
    }



    public void onHelloButtonClick4(ActionEvent event) {
        if (input.getText().isEmpty()) {
            label3.setText("Please type in a username");
            Login=false;}
        else {
            Login=true;
            label3.setText("");
            label4.setText("username valid");
            Data.username = input.getText();
            continue1.setVisible(true);
        }
    }

    public void onHelloButtonClick6(ActionEvent event) throws IOException {
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
