package tictactoe;

import tictactoe.controllers.MainMenuController;
import tictactoe.controllers.GameBoardController;
import tictactoe.models.CellState;
import tictactoe.models.GameResult;

public class TicTacToe {
    public static final int BOARD_SIZE = 3;
    private static final StartWindow startWindow = new StartWindow();
    private static final MainMenuController mainMenuController = new MainMenuController(startWindow);
    private static final GameBoardController gameBoardController = new GameBoardController(startWindow);

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.run();
    }

    public void run() {
        startWindow.show();
    }

    public static void showMainMenu() {
        mainMenuController.show();
    }

    public static void hideMainMenu() {
        mainMenuController.hide();
    }

    public static void startGame() {
        gameBoardController.startGame();
    }

    public static boolean move(int row, int col) {
        return gameBoardController.move(row, col);
    }

    public static CellState nextMove() {
        return gameBoardController.nextMove();
    }

    public static GameResult gameResult() {
        return gameBoardController.gameResult();
    }

    public static void clearGameBoard() {
        gameBoardController.clearGameBoard();
    }

    public static void endGame() {
        gameBoardController.endGame();
    }

    public static void exit() {
        startWindow.end();
    }
}
