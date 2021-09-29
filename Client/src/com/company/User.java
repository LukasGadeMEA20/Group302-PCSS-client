package com.company;

import java.util.Scanner;

public class User {
    String userName;
    int points;
    boolean inLobby;
    boolean afk;
    float afkTimer;
    boolean ready;

    String randomPrompt;
    String answer;

    public void setUserName(String userName) { //sets the username of a user
        this.userName = userName;
    }

    public String getUserName() { //gets the assigned username from the user object
        return this.userName;
    }

    public void setPoints(int points) { //sets the points of a user
        this.points = points;
    }

    public int getPoints() { //gets the points of a user
        return this.points;
    }

    public void writeAnswer() {
        System.out.print(randomPrompt);
        java.util.Scanner in = new Scanner(System.in);
        answer = in.next();
    }

    public void setAnswer(String answer) { //sets the username of a user
        this.answer = answer;
    }

    public String getAnswer() { //sets the username of a user
        return this.answer;
    }
}