package tictactoe;

import tictactoe.controllers.EndGameController;
import tictactoe.controllers.MainMenuController;
import tictactoe.controllers.StartGameController;

public class TicTacToe {
    private static final StartWindow startWindow = new StartWindow();
    private static final MainMenuController mainMenuController = new MainMenuController(startWindow);
    private static final StartGameController startGameController = new StartGameController(startWindow);
    private static final EndGameController endGameController = new EndGameController(startWindow);

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
        startGameController.startGame();
    }

    public static void endGame() {
        endGameController.endGame();
    }
}
