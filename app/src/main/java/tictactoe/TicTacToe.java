package tictactoe;

import tictactoe.controllers.GameSettingsController;
import tictactoe.controllers.MainMenuController;
import tictactoe.controllers.GameBoardController;
import tictactoe.models.CellState;
import tictactoe.models.GameResult;

public class TicTacToe {
    public static int BOARD_SIZE = 3;
    private static final StartWindow startWindow = new StartWindow();
    private static final MainMenuController mainMenuController = new MainMenuController(startWindow);
    private static final GameSettingsController gameSettingsController = new GameSettingsController(startWindow);
    private static final GameBoardController gameBoardController = new GameBoardController(startWindow);

    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        ticTacToe.run();
    }

    public void run() {
        startWindow.show();
    }

    public static void updateSize(int newSize) {
        BOARD_SIZE = newSize;
        startWindow.updateSize();
    }

    public static void showMainMenu() {
        mainMenuController.show();
    }

    public static void hideMainMenu() {
        mainMenuController.hide();
    }

    public static void showSettings() {
        TicTacToe.hideMainMenu();
        gameSettingsController.show();
    }

    public static void hideSettings() {
        gameSettingsController.hide();
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

    public static void resetGame() {
        gameBoardController.resetGame();
    }

    public static void endGame() {
        gameBoardController.endGame();
    }

    public static void exit() {
        startWindow.end();
    }
}
