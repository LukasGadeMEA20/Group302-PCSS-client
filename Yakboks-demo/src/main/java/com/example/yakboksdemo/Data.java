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

    public static boolean gameRunning = true;

    public static boolean displayList = false;

    public static String IP;
    public static int Port;

    public static String textToDisplay;
    public static ArrayList<String> listOfAnswers = new ArrayList<>();
    /*static{
        listOfAnswers.add("test1");
        listOfAnswers.add("test2");
        listOfAnswers.add("test3");
        listOfAnswers.add("test4");
    }*/
    public static ObservableList<String> listOfAnswersForList = FXCollections.observableArrayList();

    public static int winningCard = -1;
    public static int selectedCard = -1;
}
