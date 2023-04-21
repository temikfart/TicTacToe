package tictactoe.views;

import tictactoe.StartWindow;

import java.awt.*;

public class GameBoardView {
    private final StartWindow startWindow;
    private Label title = createTitle();

    public GameBoardView(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public void addComponents() {
        startWindow.addComponent(title);
    }

    public void removeComponents() {
        startWindow.removeComponent(title);
    }

    public Label createTitle() {
        Label title = new Label("Tic Tac Toe");
        title.setBounds(150, 100, 200, 100);
        return title;
    }
}
