package com.example.yakboksdemo;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterCardTextController implements Initializable {
    @FXML
    public TextField promptInput;
    @FXML
    public Label labelSubmission;

    @FXML
    public Pane playerUI;

    @FXML
    public Pane cardCzarUI;
    public ListView<String> myListView;


    @FXML
    public void onExitClick(ActionEvent event) {
        System.exit(1);
    }

    public void onReturnClick(ActionEvent event) throws IOException {
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

    public void onSubmitClick(ActionEvent event) throws IOException {
        if(!Data.isHost){
            Data.submission = promptInput.getText();
        } else {
            Data.winningCard = Data.selectedCard;
        }

        /*
        Parent scene_8_parent = FXMLLoader.load(getClass().getResource("PromptAnswers.fxml"));
        Scene scene8 = new Scene(scene_8_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene8);
        app_stage.show();*/
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(Data.gameRunning){
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            labelSubmission.setText(Data.textToDisplay);

                            if(Data.isCardCzar){
                                setCardCzarUI();
                            } else {
                                setPlayerUI();
                            }
                        }

                        public void setCardCzarUI(){
                            playerUI.setVisible(false);

                            // Only shows
                            if(Data.displayList){
                                cardCzarUI.setVisible(true);

                                myListView.getItems().setAll(Data.listOfAnswersForList);

                                myListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                                    @Override
                                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                                        Data.selectedCard = myListView.getSelectionModel().getSelectedIndex();
                                    }
                                });
                                Data.displayList = false;
                            }
                        }

                        public void setPlayerUI(){
                            playerUI.setVisible(true);
                            cardCzarUI.setVisible(false);
                        }
                    });
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}

