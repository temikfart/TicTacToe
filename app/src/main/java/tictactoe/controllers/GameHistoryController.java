package tictactoe.controllers;

import tictactoe.models.GameHistoryModel;
import tictactoe.views.GameHistoryView;

import java.io.IOException;

public class GameHistoryController {
    private final GameHistoryView gameHistoryView;
    private final GameHistoryModel gameHistoryModel;

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
