package com.example.yakboksdemo;

import javafx.collections.FXCollections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientRunnable implements Runnable {
    String userName; // Username
    Socket connectToServer; // Socket

    // IP and Port
    String IP;
    int port;

    // constructor for if you wanted to connect the socket before. (We found this to be most optimal.)
    ClientRunnable(String _userName, Socket _socket){
        userName = _userName;
        connectToServer = _socket;
    }

    // constructor for if you wanted to connect to socket through the thread.
    ClientRunnable(String _userName, String _IP, int _port) {
        userName = _userName;
        IP = _IP;
        port = _port;
    }

    @Override
    public void run() {
        // boolean for running the game.
        boolean connect = true;

        try {
            //Socket connectToServer = new Socket(IP, port); deprecated code.

            // Gets the input and output stream for the client.
            DataInputStream fromServer = new DataInputStream(connectToServer.getInputStream());
            DataOutputStream toServer = new DataOutputStream(connectToServer.getOutputStream());

            // Writes the username to the server
            toServer.writeUTF(userName);

            while(connect){
                int state = fromServer.readInt(); // reads the state from the server.
                switch(state){
                    // The first case is for the host of the server.
                    case 0:
                        // Sets that user to be the host.
                        Data.isHost = true;

                        // Confirming the current state of the lobby.
                        int confirm = Data.lobbyChoice;

                        // Writes it to the server.
                        toServer.writeInt(confirm);
                        // If the confirm variable is 1, meaning that the lobby is open.
                        if (confirm == 1){
                            // first it resets the usernames arraylist so it does not continually add the same users again and again.
                            Data.userNames = new ArrayList<String>();
                            // Gets the amount of users joined
                            int usersJoined = fromServer.readInt();
                            for(int i = 0; i < usersJoined; i++){
                                // Adds the usernames of the users
                                Data.userNames.add(fromServer.readUTF());
                            }
                            // Updates the list of usernames, which gets used in the lobby menu listView
                            Data.userNamesForList = FXCollections.observableArrayList(Data.userNames);
                        }
                        System.out.print(""); // has to be here to keep the thread awake
                        // Sometimes it would just stop and keep the players from starting the game properly.
                        Thread.sleep(500); // waits half a second.

                        break;
                    case 1: // Case for the other players in the lobby
                        // Tells the user they are connected to the server in the console.
                        System.out.println("You are connected to the server");
                        // Does the same above with updating the list of users joined.
                        Data.userNames = new ArrayList<String>();
                        int temp = fromServer.readInt();
                        for(int i = 0; i < temp; i++){
                            Data.userNames.add(fromServer.readUTF());
                        }
                        Data.userNamesForList = FXCollections.observableArrayList(Data.userNames);
                        break;

                    case 2: // CardCzar case
                        //System.out.println("YOU ARE CZAR");
                        startNewRound(); // resets information.

                        // Sets the user to be the cardCzar
                        Data.isCardCzar = true;

                        // Reads the prompt from the server and sets it in the data.
                        Data.prompt = fromServer.readUTF();

                        // Sets the text to display
                        Data.textToDisplay = "Please wait while the other users write an answer for the prompt: \n" + Data.prompt;

                        // checks from the server if everyone has sent in their answers for the prompt before continuing.
                        boolean allReady = false;
                        while(!allReady){
                            if(fromServer.readBoolean()){
                                allReady = true;
                            }
                        }

                        // Gets the size of the answers list
                        int size = fromServer.readInt();

                        // Reads each of the answers from the server and adds them to a list
                        for(int i = 0; i < size; i++){
                            Data.listOfAnswers.add(fromServer.readUTF());
                        }

                        // Which gets added to an observable list for the listview in EnterCardText scene.
                        Data.listOfAnswersForList = FXCollections.observableArrayList(Data.listOfAnswers);

                        // Tells the program that it should display the list after that
                        Data.displayList = true;

                        // Flushes the stream as sometimes it would bug out
                        toServer.flush();

                        // waits until the cardCzar has made a choice by continually checking if the winningCard is -1 or not.
                        // It will always be 0 or above once the cardCzar has made a choice.
                        boolean choiceMade = false;
                        while(!choiceMade){
                            if(Data.winningCard != -1){
                                toServer.writeInt(Data.winningCard);
                                choiceMade = true;
                            }
                            Thread.sleep(500); // waits a bit inbetween the checks.
                        }

                        // Reads the winning card string from the server to display.
                        String winCard = fromServer.readUTF();
                        Data.textToDisplay = "The winner of this round is " + winCard;
                        Thread.sleep(5000); // Waits 5 seconds before continuing, to showcase the winner.

                        break;
                    case 3: // This case if for the other players who write in their answers.
                        startNewRound(); // resets like the cardCzar
                        Data.isCardCzar = false; // sets the boolean to false, for when a cardCzar becomes a player.

                        // Reads the prompt for the server.
                        Data.prompt = fromServer.readUTF();

                        // Displays the prompt and instructions.
                        Data.textToDisplay = "Write a funny answer for the prompt: \n" + Data.prompt;
                        //System.out.println(Data.textToDisplay);

                        // Waits till the user writes an answer.
                        boolean userWritten = false;
                        while(!userWritten) {
                            if (!Data.userSubmission.equals("")) {
                                toServer.writeUTF(Data.userSubmission);
                                userWritten = true;
                            }
                            Thread.sleep(500);
                        }

                        // Displays the winner of the round.
                        Data.textToDisplay = "The winner of this round is " + fromServer.readUTF();
                        Thread.sleep(5000);

                        break;
                    case 4: // final case which is for ending the game.
                        Data.textToDisplay = fromServer.readUTF(); // reads the text to display
                        Data.gameRunning = false; // tells the program that the game is not running anymore
                        connect = false; // tells the program that it is not connected anymore.
                        break;
                }
                // After each case it flushes the datastream to make sure nothing bad gets through.
                toServer.flush();
                // At the end it sets the connected boolean to be true.
                // It might seem weird, but this is used to tell the client that it is connected to the server
                // So it can display the list of users in the lobby. Why is it done here? Well we want the data it displays to be loaded.
                if(!Data.connected) {
                    Data.connected = true;
                }
            }
            // Disconnects itself from the server once it is out of the while loop.
            connectToServer.close();
        // Catches error
        } catch(IOException | InterruptedException e){
            System.out.println(e.toString());
        }
    }

    // Method for starting a new round.
    public void startNewRound(){
        // We set the lobby choice to be equal to 0, to get away from the lobby here.
        // We do this together when the game gets updated.
        if(Data.lobbyChoice != 0) {
            Data.lobbyChoice = 0;
        }

        // Resets all the information of the user.
        Data.winningCard = -1;
        Data.listOfAnswers = new ArrayList<>();
        Data.userSubmission = "";
    }
}
