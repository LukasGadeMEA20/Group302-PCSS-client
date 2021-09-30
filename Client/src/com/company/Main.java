package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameClient g = new GameClient();
        Prompt prompt = new Prompt();
        User u = new User();
        int numOfPlayers=1;
        ArrayList<User>userlist=new ArrayList<User>(numOfPlayers); //Declares the arraylist with all the users as objects



        System.out.println("\n");

        for (int i = 0; i < numOfPlayers; i++) {   //for loop for input of credentials for the specific user object
            userlist.add(new User());
            g.askName();
            userlist.get(i).setUserName(g.name);
            u.choosePrompt();
            u.writeAnswer();
            userlist.get(i).setAnswer((u.answer));
            g.askPoints();
            userlist.get(i).setPoints(g.nextInt);

        }
        System.out.println("\n");

        for (int j = 0; j < numOfPlayers; j++) {//uses another for loop for printing the data for each User in the userList
        System.out.println(userlist.get(j).getUserName()+ ": " + userlist.get(j).getAnswer() + " worth: " + userlist.get(j).getPoints());
    }



    }
}
