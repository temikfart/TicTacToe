package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.models.CellState;
import tictactoe.models.GameBoardModel;
import tictactoe.models.GameResult;
import tictactoe.views.GameBoardView;

public class GameBoardController {
    private final GameBoardView gameBoardView;
    private final GameBoardModel gameBoardModel = new GameBoardModel();

    public GameBoardController(StartWindow startWindow) {
        this.gameBoardView = new GameBoardView(startWindow);
    }

    public void startGame() {
        TicTacToe.hideMainMenu();
        gameBoardView.addComponents();
    }

    public boolean move(int row, int col) {
        return gameBoardModel.move(row, col);
    }

    public CellState nextMove() {
        return gameBoardModel.nextMove();
    }

    public void clearGameBoard() {
        gameBoardView.clear();
        gameBoardModel.clear();
    }

    public GameResult gameResult() {
        return gameBoardModel.gameResult();
    }

    public void endGame() {
        clearGameBoard();
        gameBoardView.removeComponents();
        TicTacToe.showMainMenu();
    }
}
