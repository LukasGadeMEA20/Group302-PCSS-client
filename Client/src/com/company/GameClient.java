package com.company;


import java.util.Scanner;

public class GameClient {
    String ipAddres;

    void AskQuestion() {
        java.util.Scanner in = new Scanner(System.in);
        String name = in.next();
        
        System.out.println(name);
    }

}
