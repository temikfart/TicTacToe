package tictactoe.views;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.Utils;

import java.awt.*;

public class GameSettingsView {
    private final StartWindow startWindow;

    private final int MIN_SIZE = 3;
    private final int MAX_SIZE = 5;
    private final Font hintLabelFont = Utils.createBaseFont(Font.BOLD, 30);
    private final Font buttonFont = Utils.createBaseFont(Font.BOLD, 30);

    private final Label hintLabel = createHintLabel();
    private final Button[] changeSizeButtons = createChangeSizeButtons();

    public GameSettingsView(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public void addComponents() {
        startWindow.setLayout(new GridLayout(0, 1));
        startWindow.addComponent(hintLabel);
        for (Button button : changeSizeButtons)
            startWindow.addComponent(button);
    }

    public void removeComponents() {
        startWindow.removeComponent(hintLabel);
        for (Button button : changeSizeButtons)
            startWindow.removeComponent(button);
    }

    private Label createHintLabel() {
        Label hint = new Label("Choose Game Board Size");
        hint.setAlignment(Label.CENTER);
        hint.setFont(hintLabelFont);

        return hint;
    }

    private Button[] createChangeSizeButtons() {
        Button[] buttons = new Button[MAX_SIZE - MIN_SIZE + 1];
        for (int i = MIN_SIZE; i <= MAX_SIZE; i++) {
            Button b = new Button(i + "x" + i);
            b.setFont(buttonFont);
            int newSize = i;
            b.addActionListener(e -> {
                TicTacToe.updateSize(newSize);
                TicTacToe.startGame();
            });
            buttons[i - MIN_SIZE] = b;
        }

        return buttons;
    }
}
