package com.example.yakboksdemo;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;

public class LobbyRefresher implements Runnable{
    ListView<String> listView;

    LobbyRefresher(ListView<String> _listView){
        listView = _listView;
    }

    @Override
    public void run() {
        while(Data.lobbyChoice != 0) {
            listView.setItems(Data.userNamesForList);
        }
    }
}
