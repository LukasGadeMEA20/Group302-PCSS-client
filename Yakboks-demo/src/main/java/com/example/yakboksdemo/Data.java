package com.example.yakboksdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Data {
    public static Stage veryDumbCode = null;

    public static String username = "";
    public static String submission = "";
    public static String kort = " is a really good excuse to take a break ";

    public static ArrayList<String> userNames = new ArrayList<String>();
    public static ObservableList<String> userNamesForList = FXCollections.observableArrayList();

    public static int lobbyChoice = -1;

    public static boolean isHost = false;

    public static boolean connected = false;

    public static String IP;
    public static int Port;

    public static String textToDisplay;
    public static String listOfAnswers;
    public static String thisUserAnswer;
    public static int winningCard;
}
