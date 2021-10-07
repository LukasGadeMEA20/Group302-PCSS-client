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
            Socket connectToServer = new Socket("localHost", 12345);

            DataInputStream input = new DataInputStream(connectToServer.getInputStream());
            DataOutputStream output = new DataOutputStream(connectToServer.getOutputStream());
            while(connect){
                System.out.println("Enter username");
                String userName = scannerInput.next();

                output.writeUTF(userName);

                output.flush();
                /*System.out.print("Enter annual interest rate: ");
                double annualInterestRate = scannerInput.nextDouble();

                System.out.print("Enter an amount of years: ");
                int numberOfYears = scannerInput.nextInt();

                System.out.print("Enter loan amount: ");
                double loan = scannerInput.nextDouble();

                output.writeDouble(annualInterestRate);
                output.writeInt(numberOfYears);
                output.writeDouble(loan);
                output.flush();

                double monthlyPayment = input.readDouble();
                double totalPayment = input.readDouble();

                System.out.println("Annual interest rate: " + annualInterestRate
                               + "\nNumber of years: " + numberOfYears
                               + "\nLoan amount: " + loan);

                System.out.println("Monthly payment: " + monthlyPayment
                                 + "\nTotal payment: " + totalPayment);*/

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
