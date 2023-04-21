package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.views.GameBoardView;

public class StartGameController {
    private final StartWindow startWindow;
    private final GameBoardView gameBoardView;

    public StartGameController(StartWindow startWindow) {
        this.startWindow = startWindow;
        this.gameBoardView = new GameBoardView(startWindow);
    }

    public void startGame() {
        startWindow.hideMainMenu();
        gameBoardView.setVisible(true);
    }
}
