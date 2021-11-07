package com.example.yakboksdemo;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

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


    // Exits the program.
    @FXML
    public void onExitClick(ActionEvent event) {
        System.exit(1);
    }

    // Submit button is different for the cardCzar and the other players.
    public void onSubmitClick(ActionEvent event) throws IOException {
        if(Data.isCardCzar){ // If the user is the cardCzar, it will set the winning answer to be the answer they selected.
            Data.winningCard = Data.selectedCard;
        } else { // For the other players it will take what they wrote and add it as their submission. Then it will clear the textfield.
            Data.userSubmission = promptInput.getText();
            promptInput.clear();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // New thread for updating the game flow.
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(Data.gameRunning){ // As long as the game is running, it will update the UI with a Platform.runLater.
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            labelSubmission.setText(Data.textToDisplay); // Updates the label on the screen to be whatever is needed.

                            // Sets the rest of the UI based on if they are the cardCzar or one of the other players
                            if(Data.isCardCzar){
                                setCardCzarUI();
                            } else {
                                setPlayerUI();
                            }
                        }

                        public void setCardCzarUI(){
                            // For the cardCzar ui we hide the player UI first
                            playerUI.setVisible(false);

                            // Then we show the cardCzar UI once the boolean displayList is true
                            // It is set to true in the ClientRunnable thread, once everyone has sent in their answers.
                            if(Data.displayList){
                                cardCzarUI.setVisible(true); // UI

                                myListView.getItems().setAll(Data.listOfAnswersForList); // updates the list with the answers

                                // Adds a listener to each element in the list, which reacts when clicked on.
                                myListView.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
                                    @Override
                                    public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                                        Data.selectedCard = myListView.getSelectionModel().getSelectedIndex(); // Sets the selectedCard based on the selection from the user.
                                        // It does not send it right away, just so people do not accidentally click the wrong one, and sends it.
                                    }
                                });
                                // I cannot recall why I have this here, and I could not test what would happen if I removed it.
                                // It might be very bad code, but I decided to leave it, as the program works fine ¯\_(ツ)_/¯
                                Data.displayList = false;
                            }
                        }

                        // The player UI is very simple, as it just hides and shows two different UI's.
                        public void setPlayerUI(){
                            cardCzarUI.setVisible(false);
                            playerUI.setVisible(true);
                        }
                    });
                    // TODO see if you can remove this or not. It should be removable, but it might fuck the code up.
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // When the gameRunning is set to false, it will start this Platform.runLater thread which just shows who won,
                // while hiding all unnecessary stuff.
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        labelSubmission.setText(Data.textToDisplay);
                        playerUI.setVisible(false);
                        cardCzarUI.setVisible(false);
                    }
                });
            }
        }).start();
    }
}

