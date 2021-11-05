package com.example.yakboksdemo;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LobbyMenuController implements Initializable {
    @FXML
    public Button continueHostButton;
    public ListView<String> myListView;

    @FXML
    public void onContinueClick(ActionEvent event) throws IOException {
        if(Data.isHost) {
            // Sets the lobby status to be 0 if the host clicks it.
            // This changes the scene the game scene.
            Data.lobbyChoice = 0;
        }
    }

    // exits the program.
    public void onExitClick(ActionEvent event) {
        System.exit(1);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        // Sets the continue button to be visible, based on if they are host or not.
        continueHostButton.setVisible(Data.isHost);

        // Sets the lobby status to be 1, meaning it updates and takes in new members.
        Data.lobbyChoice = 1;

        // This thread is for updating the lobby in checking if there are new who joined the lobby
        // But it also checks whether the game should start, which it does when the first who joins clicks the continue button.
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    String dot = ".";       // For status of connection. Shown through multiple dots. Why? Because it is handy and funny.
                    boolean checker = true; // Checker which runs until the lobby changes
                    // When we look at this code it is very cluttered and could be optimized a lot.
                    // We did not have the time for it, so we did not bother with doing it.
                    while(checker){
                        if(Data.connected && Data.lobbyChoice != 0) { // if it is connected and the lobby status is not 0, it updates the listview of users joined.
                            Platform.runLater(new Runnable() { // VERY IMPORTANT WE USE A PLATFORM.RUNLATER THREAD
                                // Platform.runLater is a javaFX specific thread which MUST be used when trying to change the ui through a thread.
                                @Override
                                public void run() {
                                    // Gets the list of users and updates the listview
                                    myListView.getItems().setAll(Data.userNamesForList);
                                    continueHostButton.setVisible(Data.isHost); // Sets the visibility of the button continually. This is due to people taking time to join due to slow pc/internet.
                                }
                            });

                            // Sleeps the program for half a second, so it does not run a million times a second.
                            Thread.sleep(500);
                        } else if (Data.lobbyChoice == 0){ // When the lobby choice is 0, meaning the host pressed the button
                            checker = false; // the checker is set to false, meaning it will not run the loop again.
                            // New thread for the javaFX UI
                            Platform.runLater(new Runnable() {
                                @Override
                                public void run() {
                                    try {
                                        // Loads the next scene.
                                        Parent scene_5_parent = FXMLLoader.load(getClass().getResource("EnterCardText.fxml"));
                                        Scene scene5 = new Scene(scene_5_parent);
                                        Data.stage.setScene(scene5);
                                        Data.stage.show();
                                    } catch (IOException e) {
                                        e.printStackTrace();
                                    }
                                }
                            });
                        } else {
                            // Prints status in the console every a second.
                            System.out.println("Connecting"+dot);
                            dot+=".";
                            // Just to make it update as it joins.
                            if(dot.length()==3){
                                dot=".";
                            }
                            Thread.sleep(1000);
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        t.setPriority(10); // Sets this thread to have utmost importance before starting it.
        t.start();
    }
}

