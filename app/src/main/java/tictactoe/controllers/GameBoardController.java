package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.models.CellState;
import tictactoe.models.GameBoardModel;
import tictactoe.models.GameResult;
import tictactoe.views.GameBoardView;

public class GameBoardController {
    private final StartWindow startWindow;
    private GameBoardView gameBoardView;
    private GameBoardModel gameBoardModel;

    public GameBoardController(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public void startGame() {
        TicTacToe.hideSettings();
        gameBoardView = new GameBoardView(startWindow);
        gameBoardModel = new GameBoardModel();
        gameBoardView.addComponents();
    }

    public boolean move(int row, int col) {
        return gameBoardModel.move(row, col);
    }

    public CellState nextMove() {
        return gameBoardModel.nextMove();
    }

    private void clearGameBoard() {
        gameBoardView.clear();
        gameBoardModel.clear();
    }

    public GameResult gameResult() {
        return gameBoardModel.gameResult();
    }

    public void resetGame() {
        clearGameBoard();
    }

    public void endGame() {
        resetGame();
        gameBoardView.removeComponents();
        TicTacToe.showMainMenu();
    }
}
