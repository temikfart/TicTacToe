package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.views.MainMenuView;

public class MainMenuController {
    private final StartWindow startWindow;

    private final MainMenuView mainMenuView;

    public MainMenuController(StartWindow startWindow) {
        this.startWindow = startWindow;
        this.mainMenuView = new MainMenuView(startWindow);
    }

    public void show() {
        mainMenuView.setVisible(true);
    }

    public void hide() {
        mainMenuView.setVisible(false);
    }
}
