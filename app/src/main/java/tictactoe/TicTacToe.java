package tictactoe;

import tictactoe.controllers.MainMenuController;
import tictactoe.controllers.GameBoardController;

public class TicTacToe {
    public static final int BOARD_WIDTH = 3;
    public static final int BOARD_HEIGHT = 3;
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

    public static void endGame() {
        gameBoardController.endGame();
    }

    public static void exit() {
        startWindow.end();
    }
}
