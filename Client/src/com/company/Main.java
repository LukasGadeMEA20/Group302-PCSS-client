package com.company;

import java.util.Scanner;

public class Main {


    int[] userList = {1, 2, 3};
    public static void main(String[] args) {
	// write your code here
        GameClient g = new GameClient();
        User[] userList = new User[3]; //Declares the array with all the user as objects
        //for loop for input of credentials for the specific user object
        for (int i=0; i<3; i++) {
            userList[i] = new User();
            g.askName();
            userList[i].setUserName(g.name);
            g.askPoints();
            userList[i].setPoints(g.nextInt);
            System.out.println(userList[i].getUserName()+ ": " + userList[i].getPoints());
        }
        //prints out all user object in the array
        System.out.println("User 1: " + userList[0].getUserName() + ": " + userList[0].getPoints());
        System.out.println("User 2: " + userList[1].getUserName() + ": " + userList[1].getPoints());
        System.out.println("User 3: " + userList[2].getUserName() + ": " + userList[2].getPoints());



    }
}
