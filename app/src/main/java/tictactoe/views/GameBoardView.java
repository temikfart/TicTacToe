package tictactoe.views;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.Utils;

import java.awt.*;

public class GameBoardView {
    private final StartWindow startWindow;
    private final GridBagLayout layout = new GridBagLayout();

    private final Font titleFont = Utils.createBaseFont(Font.BOLD, 30);
    private final Font returnButtonFont = Utils.createBaseFont(Font.BOLD, 20);
    private final int buttonWidth = 100;
    private final int buttonHeight = 100;

    private final Label title = createTitle();
    private final GridBagConstraints titleGridContaints = createTitleConstraints();
    private final Button[][] gameBoardButtons = createGameBoardButtons();
    private final GridBagConstraints[][] gameBoardButtonsConstraints = createGameBoardButtonsConstraints();
    private final Button returnButton = createReturnButton();
    private final GridBagConstraints returnButtonConstraints = createReturnButtonConstraints();

    public GameBoardView(StartWindow startWindow) {
        this.startWindow = startWindow;
    }

    public void addComponents() {
        startWindow.setLayout(layout);
        addConstraints();
        startWindow.addComponent(title);
        for (Button[] buttonsRow : gameBoardButtons)
            for (Button b : buttonsRow)
                startWindow.addComponent(b);
        startWindow.addComponent(returnButton);
    }

    public void removeComponents() {
        startWindow.removeComponent(title);
        for (Button[] buttonsRow : gameBoardButtons)
            for (Button b : buttonsRow)
                startWindow.removeComponent(b);
        startWindow.removeComponent(returnButton);
    }

    private void addConstraints() {
        layout.setConstraints(title, titleGridContaints);
        for (int i = 0; i < TicTacToe.BOARD_WIDTH; i++) {
            for (int j = 0; j < TicTacToe.BOARD_HEIGHT; j++)
                layout.setConstraints(gameBoardButtons[i][j], gameBoardButtonsConstraints[i][j]);
        }
        layout.setConstraints(returnButton, returnButtonConstraints);
    }

    private Label createTitle() {
        Label title = new Label("Tic Tac Toe");
        title.setAlignment(Label.CENTER);
        title.setFont(titleFont);

        return title;
    }

    private GridBagConstraints createTitleConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = TicTacToe.BOARD_WIDTH;

        return constraints;
    }

    private Button[][] createGameBoardButtons() {
        Button[][] buttons = new Button[TicTacToe.BOARD_WIDTH][TicTacToe.BOARD_HEIGHT];
        for (Button[] buttonsRow : buttons) {
            for (int j = 0; j < TicTacToe.BOARD_HEIGHT; j++) {
                Button b = new Button();
                b.setBackground(Color.GRAY);
                b.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
                buttonsRow[j] = b;
            }
        }

        return buttons;
    }

    private GridBagConstraints[][] createGameBoardButtonsConstraints() {
        GridBagConstraints[][] constraints = new GridBagConstraints[3][3];
        for (int i = 0; i < TicTacToe.BOARD_WIDTH; i++) {
            GridBagConstraints[] constraintsRow = constraints[i];
            for (int j = 0; j < TicTacToe.BOARD_HEIGHT; j++) {
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = j;
                c.gridy = i + 1;
                constraintsRow[j] = c;
            }
        }

        return constraints;
    }

    private Button createReturnButton() {
        Button button = new Button("Menu");
        button.addActionListener(e -> TicTacToe.endGame());
        button.setFont(returnButtonFont);

        return button;
    }

    private GridBagConstraints createReturnButtonConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = TicTacToe.BOARD_HEIGHT + 1;

        return constraints;
    }
}
