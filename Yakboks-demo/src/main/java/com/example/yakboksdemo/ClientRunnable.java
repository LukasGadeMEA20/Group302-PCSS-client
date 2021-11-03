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
    int Port;


    ClientRunnable(String _userName, String _IP, int _port) {
        userName = _userName;
        IP = _IP;
        Port = _port;
    }

    @Override
    public void run() {
        Scanner scannerInput= new Scanner(System.in);
        boolean connect = true;
        String prompt;

        try {
            Socket connectToServer = new Socket(IP, Port);

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
                        Data.lobbyChoice = 0;
                        prompt = fromServer.readUTF();
                        Data.kort = prompt;

                        Data.textToDisplay = "Please wait while the other users write an answer for the prompt: \n" + Data.kort;
                        System.out.println(Data.textToDisplay);

                        Data.listOfAnswers = fromServer.readUTF();
                        System.out.println(Data.listOfAnswers);

                        toServer.flush();

                        boolean choiceMade = false;
                        while(!choiceMade){
                            if(Data.winningCard != -1){
                                toServer.writeInt(Data.winningCard);
                                choiceMade = true;
                            }
                            Thread.sleep(2000);
                        }

                        break;
                    case 3:
                        if(Data.lobbyChoice != 0) {
                            Data.lobbyChoice = 0;
                        }

                        prompt = fromServer.readUTF();

                        Data.kort = prompt;

                        Data.textToDisplay = "Write a funny answer for the prompt: \n" + Data.kort;
                        //System.out.println(Data.textToDisplay);

                        boolean userWritten = false;
                        while(!userWritten) {
                            if (Data.thisUserAnswer.equals("")) {
                                toServer.writeUTF(Data.thisUserAnswer);
                                userWritten = true;
                            }
                            Thread.sleep(2000);
                        }
                        System.out.println(Data.thisUserAnswer);

                        break;
                    case 4:
                        System.out.println(fromServer.readUTF());
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
}
