package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GameClient g = new GameClient();
        Prompt prompt = new Prompt();
        User u = new User();
        int sizeOfArr=3;
        ArrayList<User>userlist=new ArrayList<User>(sizeOfArr); //Declares the arraylist with all the users as objects
        Prompt p=new Prompt();

        p.choosePrompt();
        p.askPrompt();
        System.out.println("\n");

        for (int i = 0; i < 3; i++) {   //for loop for input of credentials for the specific user object
            userlist.add(new User());
            g.askName();
            userlist.get(i).setUserName(g.name);
            prompt.askPrompt();
            prompt.setAnswer(prompt.answer);
            g.askPoints();
            userlist.get(i).setPoints(g.nextInt);

        }
        System.out.println("\n");

        for (int j = 0; j < 3; j++) {//uses another for loop for printing the data for each User in the userList
        System.out.println(userlist.get(j).getUserName()+ ": " + userlist.get(j).getPoints());
    }



    }
}
