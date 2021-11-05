package com.example.yakboksdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Data {
    // We have no idea whether this is smart or dumb
    // But in order for us to change the display, without buttons, we created a stage static which is set when you start the program.
    public static Stage stage = null;

    // Static for saving the username
    public static String username = "";

    // Static for the user submission and the prompt
    public static String userSubmission = "";
    public static String prompt = "";

    // Two list statics, one which holds the list of users and the other is used for updating the list view.
    public static ArrayList<String> userNames = new ArrayList<>();
    public static ObservableList<String> userNamesForList = FXCollections.observableArrayList();

    // Lobby status. Used to control which stage of the lobby the program is in.
    public static int lobbyChoice = -1;

    // Boolean who controls who is the host, meaning the person who can start the game
    public static boolean isHost = false;
    // Boolean who controls if you are the person who chooses the answer who wins
    public static boolean isCardCzar = false;

    // Boolean which decides if the user is connected to the client or not.
    public static boolean connected = false;

    // Boolean which decides if the game is ongoing
    public static boolean gameRunning = true;

    // Boolean for when the program should display the answers.
    public static boolean displayList = false;

    // Static variables for connecting to the server
    public static String IP;
    public static int port;

    // A text variable we change dynamically throughout the program.
    public static String textToDisplay;

    // Two lists to store the answers from the users.
    public static ArrayList<String> listOfAnswers = new ArrayList<>();
    public static ObservableList<String> listOfAnswersForList = FXCollections.observableArrayList();

    // Variables for the current selected card, as well as the card that won.
    public static int selectedCard = -1;
    public static int winningCard = -1;
}
