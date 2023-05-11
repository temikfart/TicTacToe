package tictactoe.controllers;

import tictactoe.views.MainView;

public class MainController {
    private static final MainView mainView = new MainView();
    public static final MainMenuController mainMenuController = new MainMenuController(mainView);
    public static final GameSettingsController gameSettingsController = new GameSettingsController(mainView);
    public static final GameBoardController gameBoardController = new GameBoardController(mainView);
    public static final GameHistoryController gameHistoryController = new GameHistoryController();

    public void start() {
        mainView.showWindow();
    }

    public static void exit() {
        mainView.dispose();
    }
}
