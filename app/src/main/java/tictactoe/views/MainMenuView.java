package tictactoe.views;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;

import java.awt.*;

public class MainMenuView {
    private final StartWindow startWindow;
    private final Label welcomeLabel = createGreetingsLabel();
    private final Button startButton = createStartButton();
    private final Button exitButton = createExitButton();

    public MainMenuView(StartWindow startWindow) {
        this.startWindow = startWindow;
        this.startWindow.addComponent(welcomeLabel);
        this.startWindow.addComponent(startButton);
        this.startWindow.addComponent(exitButton);
    }

    public void setVisible(boolean b) {
        welcomeLabel.setVisible(b);
        startButton.setVisible(b);
        exitButton.setVisible(b);
    }

    private Label createGreetingsLabel() {
        Label greetingsLabel = new Label("Tic Tac Toe");
        greetingsLabel.setBackground(new Color(169,169,169));
        greetingsLabel.setBounds(150, 100, 200, 60);
        return greetingsLabel;
    }

    private Button createStartButton() {
        Button startButton = new Button("Start Game");

        int width = 200;
        int height = 60;
        startButton.setBounds(150, 340, width, height);
        startButton.addActionListener(e -> TicTacToe.startGame());

        return startButton;
    }

    private Button createExitButton() {
        Button exitButton = new Button("Exit");

        int width = 200;
        int height = 60;
        exitButton.setBounds(150, 410, width, height);
        exitButton.addActionListener(e -> TicTacToe.endGame());

        return exitButton;
    }
}
