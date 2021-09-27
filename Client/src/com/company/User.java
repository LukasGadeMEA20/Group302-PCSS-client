package com.company;

public class User {
    String userName;
    int points;
    boolean inLobby;
    boolean afk;
    float afkTimer;
    boolean ready;

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return this.userName;
    }
    public void setPoints(int points) {
        this.points = points;
    }
    public int getPoints() {
        return this.points;
    }

}
