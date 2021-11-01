package com.example.yakboksdemo;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ClientRunnable implements Runnable {
    String userName;

    ClientRunnable(String _userName) {
        userName = _userName;
    }

    @Override
    public void run() {
        Scanner scannerInput= new Scanner(System.in);
        boolean connect = true;
        String prompt;

        try {
            Socket connectToServer = new Socket("localhost", 8000);

            DataInputStream fromServer = new DataInputStream(connectToServer.getInputStream());
            DataOutputStream toServer = new DataOutputStream(connectToServer.getOutputStream());

            toServer.writeUTF(userName);

            while(connect){
                int state = fromServer.readInt();
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
                        }

                        break;
                    case 1:
                        System.out.println("You are connected to the server");
                        break;
                    case 2:
                        prompt = fromServer.readUTF();
                        System.out.println("Please wait while the other users write an answer for the prompt: \n" + prompt);
                        Data.kort = prompt;

                        System.out.println(fromServer.readUTF());

                        toServer.flush();

                        toServer.writeInt(scannerInput.nextInt());

                        break;
                    case 3:
                        prompt = fromServer.readUTF();
                        System.out.println("Write a funny answer for the prompt: \n" + prompt);
                        Data.kort = prompt;

                        String test = scannerInput.nextLine();

                        System.out.println(test);

                        toServer.writeUTF(test);

                        break;
                    case 4:
                        System.out.println(fromServer.readUTF());
                        break;
                }
                toServer.flush();
            }
            scannerInput.close();
            connectToServer.close();
        } catch(IOException e){
            System.out.println(e.toString());
        }
    }
}
