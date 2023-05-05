package tictactoe.controllers;

import tictactoe.views.MainView;
import tictactoe.views.GameSettingsView;

public class GameSettingsController {
    private final GameSettingsView gameSettingsView;

    public GameSettingsController(MainView mainView) {
        this.gameSettingsView = new GameSettingsView(mainView);
    }

    public void show() {
        gameSettingsView.addComponents();
    }

    public void hide() {
        gameSettingsView.removeComponents();
    }
}
