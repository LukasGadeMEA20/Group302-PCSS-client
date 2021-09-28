package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    //int[] userList = {1, 2, 3};
    public static void main(String[] args) {
        // write your code here
        GameClient g = new GameClient();
        User u = new User();
        int sizeOfArr=3;
        ArrayList<User>userlist=new ArrayList<User>(sizeOfArr);
        //User[] userList = new User[3]; //Declares the arraylist with all the users as objects
        //for loop for input of credentials for the specific user object
        for (int i = 0; i < 3; i++) {
            userlist.add(new User());
            g.askName();
            userlist.get(i).setUserName(g.name);
            g.askPoints();
            userlist.get(i).setPoints(g.nextInt);

        }
        System.out.println("\n");

        for (int j = 0; j < 3; j++) {//uses another for loop for printing the data for each User in the userList
        System.out.println(userlist.get(j).getUserName()+ ": " + userlist.get(j).getPoints());
    }
        //prints out all user object in the array
        //System.out.println("User 1: " + userList[0].getUserName() + ": " + userList[0].getPoints());
        //System.out.println("User 2: " + userList[1].getUserName() + ": " + userList[1].getPoints());
        //System.out.println("User 3: " + userList[2].getUserName() + ": " + userList[2].getPoints());



    }
}
