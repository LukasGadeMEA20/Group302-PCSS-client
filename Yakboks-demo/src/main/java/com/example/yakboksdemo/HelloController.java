package com.example.yakboksdemo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class HelloController {
    @FXML
    private Label welcomeText;
    private Label l;
    private Label b;
    @FXML private TextField input;
    @FXML private Label output;
    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        output.setText(input.getText());
        System.out.println(input.getText());
    }
}