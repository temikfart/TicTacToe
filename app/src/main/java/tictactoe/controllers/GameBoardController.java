package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.views.GameBoardView;

public class GameBoardController {
    private final GameBoardView gameBoardView;

    public GameBoardController(StartWindow startWindow) {
        this.gameBoardView = new GameBoardView(startWindow);
    }

    public void startGame() {
        TicTacToe.hideMainMenu();
        gameBoardView.addComponents();
    }

    public void endGame() {
        gameBoardView.removeComponents();
        TicTacToe.showMainMenu();
    }
}
