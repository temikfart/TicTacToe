package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.views.GameBoardView;

public class StartGameController {
    private final StartWindow startWindow;
    private final GameBoardView gameBoardView;

    public StartGameController(StartWindow startWindow) {
        this.startWindow = startWindow;
        this.gameBoardView = new GameBoardView(startWindow);
    }

    public void startGame() {
        TicTacToe.hideMainMenu();
        gameBoardView.addComponents();
    }
}
