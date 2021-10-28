package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scannerInput= new Scanner(System.in);
        boolean connect = true;

        try {
            Socket connectToServer = new Socket("localhost", 8000);

            DataInputStream fromServer = new DataInputStream(connectToServer.getInputStream());
            DataOutputStream toServer = new DataOutputStream(connectToServer.getOutputStream());

            while(connect){
                int state = fromServer.readInt();
                switch(state){
                    case 0:
                        System.out.println("Write '0' when everyone is ready.");
                        toServer.writeInt(scannerInput.nextInt());
                        break;
                    case 1:
                        break;
                    case 2:
                        System.out.println(fromServer.readUTF());
                        System.out.println(fromServer.readUTF());
                        toServer.writeInt(scannerInput.nextInt());
                        break;
                    case 3:
                        System.out.println("Write a funny answer for the prompt: \n" + fromServer.readUTF());
                        String test = scannerInput.nextLine();
                        System.out.println(test);
                        toServer.writeUTF(test);
                        break;
                    case 4:
                        System.out.println(fromServer.readUTF());
                        break;
                    case 5:
                        break;
                }
                //String prompt = fromServer.readUTF();
                //System.out.println(prompt);
                //System.out.println("Enter your answer");
                //String userName = scannerInput.nextLine();

                //output.writeUTF(userName);

                toServer.flush();

                //System.out.print("Do you wish to continue with a new set of values? ");

                toServer.writeInt(0);

                /*if(scannerInput.next().equals("no")){
                    connect = false;
                }*/
            }
            scannerInput.close();
            connectToServer.close();
        } catch(IOException e){
            System.out.println(e.toString());
        }
    }
}
