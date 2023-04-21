package tictactoe.views;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.Utils;

import java.awt.*;

public class MainMenuView {
    private final StartWindow startWindow;
    private final Label welcomeLabel = createWelcomeLabel();
    private final Button startButton = createStartButton();
    private final Button exitButton = createExitButton();

    public MainMenuView(StartWindow startWindow) {
        this.startWindow = startWindow;

    }

    public void addComponents() {
        startWindow.addComponent(welcomeLabel);
        startWindow.addComponent(startButton);
        startWindow.addComponent(exitButton);
    }

    public void removeComponents() {
        startWindow.removeComponent(welcomeLabel);
        startWindow.removeComponent(startButton);
        startWindow.removeComponent(exitButton);
    }

    private Label createWelcomeLabel() {
        Label welcomeLabel = new Label("Tic Tac Toe");
        welcomeLabel.setAlignment(Label.CENTER);
        welcomeLabel.setFont(Utils.createBaseFont(Font.BOLD, 50));
        return welcomeLabel;
    }

    private Button createStartButton() {
        Button startButton = new Button("Start Game");
        startButton.addActionListener(e -> TicTacToe.startGame());
        startButton.setFont(Utils.createBaseFont(Font.BOLD, 30));

        return startButton;
    }

    private Button createExitButton() {
        Button exitButton = new Button("Exit");
        exitButton.addActionListener(e -> TicTacToe.endGame());
        exitButton.setFont(Utils.createBaseFont(Font.BOLD, 30));

        return exitButton;
    }
}
