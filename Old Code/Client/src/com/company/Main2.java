package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner scannerInput= new Scanner(System.in);
        boolean connect = true;

        try {
            Socket connectToServer = new Socket("localHost", 12345);

            DataInputStream input = new DataInputStream(connectToServer.getInputStream());
            DataOutputStream output = new DataOutputStream(connectToServer.getOutputStream());
            while(connect){
                System.out.println("Enter username");
                String userName = scannerInput.next();

                output.writeUTF(userName);

                output.flush();

                System.out.print("Do you wish to continue with a new set of values? ");
                if(scannerInput.next().equals("no")){
                    connect = false;
                }
            }
            scannerInput.close();
            connectToServer.close();
        } catch(IOException e){
            System.out.println(e.toString());
        }
    }
}