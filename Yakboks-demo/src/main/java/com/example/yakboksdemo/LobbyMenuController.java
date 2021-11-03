package com.example.yakboksdemo;

import javafx.application.Platform;
import javafx.application.Application;
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

public class LobbyMenuController implements Initializable {
    @FXML
    public Label labelUsername;
    public Button continueHostButton;
    public ListView<String> myListView;

    @FXML
    public void onContinueClick(ActionEvent event) throws IOException {
        if(Data.isHost) {
            Data.lobbyChoice = 0;
            /*Parent scene_5_parent = FXMLLoader.load(getClass().getResource("scene5.fxml"));
            Scene scene5 = new Scene(scene_5_parent);
            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            app_stage.setScene(scene5);
            app_stage.show();*/
        }
    }

    public void onRefreshClick(ActionEvent event) throws IOException {
        Parent scene_3_parent = FXMLLoader.load(getClass().getResource("LobbyMenu.fxml"));
        Scene scene3 = new Scene(scene_3_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene3);
        app_stage.show();
    }

    public void onExitClick(ActionEvent event) {
        System.exit(1);
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
        else {
            labelUsername.setText(Data.username);
        }

        continueHostButton.setVisible(Data.isHost);

        if(Data.isHost){
            continueHostButton.setVisible(true);
        } else {
            continueHostButton.setVisible(false);
        }

        Data.lobbyChoice = 1;

        // This thread is for updating the lobby in checking if there are new who joined the lobby
        // But it also checks whether the game should start, which it does when the first who joins clicks the continue button.
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    boolean checker = true;
                    while(checker){
                        if(Data.connected && Data.lobbyChoice != 0) {
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    myListView.getItems().setAll(Data.userNamesForList);
                                    System.out.println("boobies"+Data.userNamesForList);
                                    Platform.runLater(new Runnable() {
                                        @Override
                                        public void run() {
                                            continueHostButton.setVisible(Data.isHost);
                                        }
                                    });
                                }
                            });

                            Thread.sleep(2000);
                        } else if (Data.lobbyChoice == 0){
                            checker = false;
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {

                                    Parent scene_5_parent = null;
                                    try {
                                        scene_5_parent = FXMLLoader.load(getClass().getResource("EnterCardText.fxml"));
                                        System.out.print(Data.veryDumbCode);
                                        Scene scene5 = new Scene(scene_5_parent);
                                        Data.veryDumbCode.setScene(scene5);
                                        Data.veryDumbCode.show();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                            /*
                            Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                            app_stage.setScene(scene5);
                            app_stage.show();*/
                        } else {
                            System.out.println("I have to be annoying :)");
                            Thread.sleep(2000);
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t.setPriority(10);
        t.start();
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

