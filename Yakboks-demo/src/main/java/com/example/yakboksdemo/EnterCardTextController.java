package com.example.yakboksdemo;

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
import java.net.URL;
import java.util.ResourceBundle;

public class EnterCardTextController implements Initializable {
    @FXML
    public TextField promptInput;
    @FXML
    public Label labelSubmission;




    @FXML


    public void exitProgram(ActionEvent event) {
        System.exit(1);
    }

    public void onReturnButton(ActionEvent event) throws IOException {
        Parent scene_5_parent = FXMLLoader.load(getClass().getResource("NewCard.fxml"));
        Scene scene5 = new Scene(scene_5_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene5);
        app_stage.show();
    }


    public void onMainmenuButton(ActionEvent event) throws IOException {
        Parent scene_2_parent = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        Scene scene2 = new Scene(scene_2_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene2);
        app_stage.show();
    }


    public void onSubmitButton(ActionEvent event) throws IOException {
        System.out.println("prut");
        Data.submission = promptInput.getText();
        Parent scene_8_parent = FXMLLoader.load(getClass().getResource("PromptAnswers.fxml"));
        Scene scene8 = new Scene(scene_8_parent);
        Stage app_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        app_stage.setScene(scene8);
        app_stage.show();

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            if (Data.submission.equals("")){
                labelSubmission.setText("blank" + Data.kort);
            }
            else{
                labelSubmission.setText(Data.submission);

            }
        }

    }

