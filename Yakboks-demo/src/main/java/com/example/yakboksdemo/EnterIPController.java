package com.example.yakboksdemo;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Node;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterIPController implements Initializable {
    @FXML
    public TextField textIP;
    public TextField textPort;


    @FXML

    public void onExitClick(ActionEvent event) {
        System.exit(1);
    }


    public void onMainMenuClick(ActionEvent event) throws IOException {
        Parent scene_2_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
        Scene scene2 = new Scene(scene_2_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }

    public void onHelloButtonClick7(ActionEvent event) throws IOException {
        if(Data.isHost) {
            Data.lobbyChoice = 0;
            Parent scene_5_parent = FXMLLoader.load(getClass().getResource("scene5.fxml"));
            Scene scene5 = new Scene(scene_5_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene5);
            app_stage.show();
        }
    }

    public void connectToServer(ActionEvent event) throws IOException {
        if (textIP.getText().isEmpty()) {

        } else {
            Data.IP = textIP.getText();


        }

        if (textPort.getText().isEmpty()) {
        } else {
            Data.Port=Integer.parseInt(textPort.getText());


        }

        System.out.println(Data.IP+Data.Port);
        new Thread(
                new ClientRunnable(Data.username, Data.IP, Data.Port)
        ).start();

        Parent scene_3_parent = FXMLLoader.load(getClass().getResource("LobbyMenu.fxml"));
        Scene scene3 = new Scene(scene_3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene3);
        app_stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}

