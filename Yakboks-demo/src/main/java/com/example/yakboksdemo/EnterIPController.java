package com.example.yakboksdemo;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

public class EnterIPController implements Initializable {
    @FXML
    public TextField textIP;
    public TextField textPort;
    public Label labelUsername;


    @FXML
    public void onExitClick(ActionEvent event) {
        System.exit(1);
    }

    // Connect button
    public void connectToServer(ActionEvent event) throws IOException {
        boolean ipFilled = false;   // Checker for if they filled the IP
        boolean portFilled = false; // Checker for if they filled the port
        if (textIP.getText().isEmpty()) {
            ipFilled = false;
        } else {
            // sets the data to be equal to the ip field
            Data.IP = textIP.getText();
            ipFilled = true;
        }

        if (textPort.getText().isEmpty()) {
            portFilled = false;
        } else {
            // sets the data to be equal to the port field
            Data.port = Integer.parseInt(textPort.getText());
            portFilled = true;
        }
        // Checks if they filled both fields
        if(ipFilled && portFilled) {
            // We create a try to check if they can connect to the server, so that the program only continues if they enter a valid IP and port.
            try{
                Socket connectToServer = new Socket(Data.IP, Data.port);

                // Start a new thread with the socket.
                new Thread(
                        new ClientRunnable(Data.username, connectToServer)
                ).start();

                // Change the scene to the lobby. Only does if the above to things succeed.
                Parent scene_3_parent = FXMLLoader.load(getClass().getResource("LobbyMenu.fxml"));
                Scene scene3 = new Scene(scene_3_parent);
                Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                app_stage.setScene(scene3);
                app_stage.show();
            } catch (IOException e){ // Prints error message in console if server does not exist
                System.out.println("The server you are trying to access does not exist, double check your IP and port");
            }
        } else { // Prints message if they left an IP or port empty.
            System.out.println("Please do not leave the IP and Port empty.");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        labelUsername.setText(Data.username);

        //We add a listener, so you can only insert numbers in the port input field.
        textPort.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    textPort.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
    }
}

