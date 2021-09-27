package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        GameClient g = new GameClient();
        User u = new User();
        System.out.print("Enter your name: ");
        g.AskQuestion();
        u.setUserName(g.name);
        System.out.println(u.getUserName());

    }
}
