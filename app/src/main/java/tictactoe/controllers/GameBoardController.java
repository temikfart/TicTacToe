package tictactoe.controllers;

import tictactoe.views.MainView;
import tictactoe.models.CellState;
import tictactoe.models.GameBoardModel;
import tictactoe.models.GameResult;
import tictactoe.views.GameBoardView;

public class GameBoardController {
    private final GameBoardView gameBoardView;
    private final GameBoardModel gameBoardModel;

    public GameBoardController(MainView mainView) {
        this.gameBoardView = new GameBoardView(mainView);
        this.gameBoardModel = new GameBoardModel();
    }

    public void startGame() {
        MainController.gameSettingsController.hide();
        gameBoardModel.reset();
        gameBoardView.reset();
    }

    public boolean move(int row, int col) {
        return gameBoardModel.move(row, col);
    }

    public CellState nextMove() {
        return gameBoardModel.nextMove();
    }
    public GameResult gameResult() {
        return gameBoardModel.gameResult();
    }

    public void endGame() {
        gameBoardModel.reset();
        gameBoardView.removeComponents();
        MainController.mainMenuController.show();
    }
}
