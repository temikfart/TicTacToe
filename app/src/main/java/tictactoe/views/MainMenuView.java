package tictactoe.views;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.Utils;

import java.awt.*;

public class MainMenuView {
    private final StartWindow startWindow;

    private final Font welcomeLabelFont = Utils.createBaseFont(Font.BOLD, 50);
    private final Font buttonFont = Utils.createBaseFont(Font.BOLD, 30);

    private final Label welcomeLabel = createWelcomeLabel();
    private final Button startButton = createStartButton();
    private final Button exitButton = createExitButton();

    public MainMenuView(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public void addComponents() {
        startWindow.setLayout(new GridLayout(0, 1));
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
        welcomeLabel.setFont(welcomeLabelFont);

        return welcomeLabel;
    }

    private Button createStartButton() {
        Button button = new Button("Start");
        button.addActionListener(e -> TicTacToe.startGame());
        button.setFont(buttonFont);

        return button;
    }

    private Button createExitButton() {
        Button button = new Button("Exit");
        button.addActionListener(e -> TicTacToe.exit());
        button.setFont(buttonFont);

        return button;
    }
}
