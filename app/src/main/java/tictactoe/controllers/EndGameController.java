package tictactoe.controllers;

import tictactoe.StartWindow;

public class EndGameController {
    private final StartWindow startWindow;

    public EndGameController(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public void endGame() {
        startWindow.end();
    }
}
