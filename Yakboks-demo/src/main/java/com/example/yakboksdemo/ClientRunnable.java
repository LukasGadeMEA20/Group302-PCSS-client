package com.example.yakboksdemo;

import javafx.collections.FXCollections;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientRunnable implements Runnable {
    String userName;
    String IP;
    int port;


    ClientRunnable(String _userName, String _IP, int _port) {
        userName = _userName;
        IP = _IP;
        port = _port;
    }

    @Override
    public void run() {
        Scanner scannerInput= new Scanner(System.in);
        boolean connect = true;
        String prompt;

        try {
            Socket connectToServer = new Socket(IP, port);

            DataInputStream fromServer = new DataInputStream(connectToServer.getInputStream());
            DataOutputStream toServer = new DataOutputStream(connectToServer.getOutputStream());

            toServer.writeUTF(userName);

            while(connect){
                int state = fromServer.readInt();
                //System.out.println(state);
                switch(state){
                    case 0:
                        //System.out.println("Write '0' when everyone is ready.");
                        Data.isHost = true;

                        int confirm = Data.lobbyChoice; //scannerInput.nextInt();

                        toServer.writeInt(confirm);
                        //System.out.println(confirm);
                        if (confirm == 1){
                            Data.userNames = new ArrayList<String>();
                            int temp = fromServer.readInt();
                            for(int i = 0; i < temp; i++){
                                Data.userNames.add(fromServer.readUTF());
                            }
                            Data.userNamesForList = FXCollections.observableArrayList(Data.userNames);
                        }
                        System.out.println(Data.userNames.toString());
                        Thread.sleep(500);

                        break;
                    case 1:
                        System.out.println("You are connected to the server");Data.userNames = new ArrayList<String>();
                        int temp = fromServer.readInt();
                        for(int i = 0; i < temp; i++){
                            Data.userNames.add(fromServer.readUTF());
                        }
                        Data.userNamesForList = FXCollections.observableArrayList(Data.userNames);
                        break;

                    case 2:
                        System.out.println("YOU ARE CZAR");
                        startNewRound();

                        // This case is the cardczar case, which means the below is set to be true.
                        Data.isCardCzar = true;

                        // Reads the prompt from the server and sets it in the data.
                        prompt = fromServer.readUTF();
                        Data.kort = prompt;

                        // Sets the text to display
                        Data.textToDisplay = "Please wait while the other users write an answer for the prompt: \n" + Data.kort;
                        //System.out.println(Data.textToDisplay);

                        //
                        boolean allReady = false;
                        while(!allReady){
                            if(fromServer.readBoolean()){
                                allReady = true;
                            }
                        }

                        int size = fromServer.readInt();
                        for(int i = 0; i < size; i++){
                            Data.listOfAnswers.add(fromServer.readUTF());
                        }
                        Data.listOfAnswersForList = FXCollections.observableArrayList(Data.listOfAnswers);

                        Data.displayList = true;

                        toServer.flush();

                        boolean choiceMade = false;
                        while(!choiceMade){
                            if(Data.winningCard != -1){
                                System.out.println("HEJ DET ER MIG!" + Data.winningCard);
                                toServer.writeInt(Data.winningCard);
                                choiceMade = true;
                            }
                            Thread.sleep(500);
                        }

                        String winCard = fromServer.readUTF();
                        Data.textToDisplay = "The winner of this round is " + winCard;

                        break;
                    case 3:
                        startNewRound();
                        Data.isCardCzar = false;

                        prompt = fromServer.readUTF();

                        Data.kort = prompt;

                        Data.textToDisplay = "Write a funny answer for the prompt: \n" + Data.kort;
                        //System.out.println(Data.textToDisplay);

                        boolean userWritten = false;
                        while(!userWritten) {
                            if (!Data.submission.equals("")) {
                                toServer.writeUTF(Data.submission);
                                userWritten = true;
                            }
                            Thread.sleep(500);
                        }
                        System.out.println(Data.submission);

                        Data.textToDisplay = fromServer.readUTF();
                        System.out.println(Data.textToDisplay);

                        break;
                    case 4:
                        Data.textToDisplay = fromServer.readUTF();
                        Data.gameRunning = false;
                        connect = false;
                        //System.out.println(fromServer.readUTF());
                        break;
                }
                toServer.flush();
                Data.connected = true;
            }
            scannerInput.close();
            connectToServer.close();
        } catch(IOException | InterruptedException e){
            System.out.println(e.toString());
        }
    }

    public void startNewRound(){
        if(Data.lobbyChoice != 0) {
            Data.lobbyChoice = 0;
        }

        Data.winningCard = -1;
        Data.listOfAnswers = new ArrayList<>();
        Data.submission = "";
    }
}
