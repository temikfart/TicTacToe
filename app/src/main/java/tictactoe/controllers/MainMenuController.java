package tictactoe.controllers;

import tictactoe.views.MainView;
import tictactoe.views.MainMenuView;

public class MainMenuController {
    private final MainMenuView mainMenuView;

    public MainMenuController(MainView mainView) {
        this.mainMenuView = new MainMenuView(mainView);
    }

    public void show() {
        mainMenuView.addComponents();
    }

    public void hide() {
        mainMenuView.removeComponents();
    }
}
