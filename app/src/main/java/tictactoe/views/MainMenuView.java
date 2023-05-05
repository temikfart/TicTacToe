package tictactoe.views;

import tictactoe.TicTacToe;
import tictactoe.Utils;
import tictactoe.controllers.MainController;
import tictactoe.models.GameBoardModel;

import javax.swing.*;
import java.awt.*;

public class MainMenuView {
    private final MainView mainView;

    private final Label welcomeLabel;
    private final Button startButton;
    private final Button exitButton;

    private final Font buttonFont = Utils.createBaseFont(Font.BOLD, 30);

    public MainMenuView(MainView mainView) {
        this.mainView = mainView;
        this.welcomeLabel = createWelcomeLabel();
        this.startButton = createStartButton();
        this.exitButton = createExitButton();
    }

    public void addComponents() {
        mainView.setLayout(new GridLayout(0, 1));
        mainView.addComponent(welcomeLabel);
        mainView.addComponent(startButton);
        mainView.addComponent(exitButton);
        mainView.updateSize(GameBoardModel.MIN_SIZE);
    }

    public void removeComponents() {
        mainView.removeComponent(welcomeLabel);
        mainView.removeComponent(startButton);
        mainView.removeComponent(exitButton);
    }

    private Label createWelcomeLabel() {
        Label welcomeLabel = new Label("Tic Tac Toe");
        welcomeLabel.setAlignment(Label.CENTER);
        welcomeLabel.setFont(Utils.createBaseFont(Font.BOLD, 50));

        return welcomeLabel;
    }

    private Button createStartButton() {
        Button button = new Button("Start");
        button.setFont(buttonFont);
        button.setActionCommand(ActionCommand.START_GAME.toString());
        button.addActionListener(mainView);

        return button;
    }

    private Button createExitButton() {
        Button button = new Button("Exit");
        button.setFont(buttonFont);
        button.setActionCommand(ActionCommand.EXIT.toString());
        button.addActionListener(mainView);

        return button;
    }
}
