package com.example.yakboksdemo;

import javafx.scene.control.ListView;

public class LobbyRefresher implements Runnable{
    ListView<String> listView;

    LobbyRefresher(ListView<String> _listView){
        listView = _listView;
    }

    @Override
    public void run() {
        while(Data.lobbyChoice != 0) {
            for (int i = 0; i < Data.userNames.size(); i++) {
                listView.getItems().add(Data.userNames.get(i));
            }
        }
    }
}
