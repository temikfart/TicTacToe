package tictactoe.controllers;

import tictactoe.models.GameHistoryModel;
import tictactoe.views.GameHistoryView;
import tictactoe.views.MainView;

import java.io.IOException;

public class GameHistoryController {
    private GameHistoryView gameHistoryView;
    private GameHistoryModel gameHistoryModel;

    public GameHistoryController() {
        try {
            this.gameHistoryModel = new GameHistoryModel();
            this.gameHistoryView = new GameHistoryView(gameHistoryModel);
        } catch (IOException e) {
            System.out.println("Can't create game history file: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    public void show() {
        gameHistoryView.showHistory();
    }

    public void saveGaveResult(String result) {
        gameHistoryModel.saveGameResult(result);
    }
}
