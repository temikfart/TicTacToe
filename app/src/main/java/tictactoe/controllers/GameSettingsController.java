package tictactoe.controllers;

import tictactoe.StartWindow;
import tictactoe.views.GameSettingsView;

public class GameSettingsController {
    private GameSettingsView gameSettingsView;

    public GameSettingsController(StartWindow startWindow) {
        this.gameSettingsView = new GameSettingsView(startWindow);
    }

    public void show() {
        gameSettingsView.addComponents();
    }

    public void hide() {
        gameSettingsView.removeComponents();
    }
}
