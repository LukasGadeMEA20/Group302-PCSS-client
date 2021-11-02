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

public class Scene3Controller implements Initializable {
    @FXML
    public Label labelUsername;
    public Button continueHostButton;
    public ListView<String> myListView;

    @FXML
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

    public void onHelloButtonClick5(ActionEvent event) throws IOException {
        Parent scene_3_parent = FXMLLoader.load(getClass().getResource("scene3.fxml"));
        Scene scene3 = new Scene(scene_3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene3);
        app_stage.show();
    }

    public void onHelloButtonClick3(ActionEvent event) {
        System.exit(1);
    }


    public void onHelloButtonClick10(ActionEvent event) throws IOException {
        Parent scene_2_parent = FXMLLoader.load(getClass().getResource("scene2.fxml"));
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
        else {
            labelUsername.setText(Data.username);
        }

        if(Data.isHost){
            continueHostButton.setVisible(true);
        } else {
            continueHostButton.setVisible(false);
        }

        Data.lobbyChoice = 1;

        System.out.println("fuck");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    while(true){
                        if(Data.connected) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    myListView.getItems().setAll(Data.userNamesForList);
                                    System.out.println("boobies"+Data.userNamesForList);
                                }
                            });

                            Thread.sleep(2000);
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
        /*Platform.runLater(new Runnable() {
            @Override
            public void run() {
                //while(Data.lobbyChoice != 0) {
                try {
                    Update();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                myListView.getItems().setAll(Data.userNamesForList);
                    //listView = new ListView<>(Data.userNamesForList);
                    //System.out.println(listView.getItems());
                //}
            }

            private void Update() throws InterruptedException {
                if(Data.connected == false){
                    Thread.sleep(2000);
                    Update();
                }
            }
        });*/
    }
}

