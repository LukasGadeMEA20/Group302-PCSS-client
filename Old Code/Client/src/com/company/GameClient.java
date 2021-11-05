package com.company;


import java.util.Scanner;

public class GameClient {
    String ipAddres;
    String name;
    int nextInt;

    void askName() {
        System.out.print("Enter your name: ");
        java.util.Scanner in = new Scanner(System.in);
        name = in.next();
    }
    void askPoints() {
        System.out.print("Enter points given: ");
        java.util.Scanner in = new Scanner(System.in);
        nextInt = in.nextInt();
    }
}
