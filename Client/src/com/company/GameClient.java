package com.company;


import java.util.Scanner;

public class GameClient {
    String ipAddres;
    String name;

    void AskQuestion() {
        java.util.Scanner in = new Scanner(System.in);
        name = in.next();
    }

}
