package tictactoe.views;

import tictactoe.StartWindow;
import tictactoe.TicTacToe;
import tictactoe.Utils;
import tictactoe.models.CellState;
import tictactoe.models.GameResult;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBoardView {
    private final StartWindow startWindow;
    private final GridBagLayout layout = new GridBagLayout();

    private final Font titleFont = Utils.createBaseFont(Font.BOLD, 30);
    private final Font returnButtonFont = Utils.createBaseFont(Font.BOLD, 17);
    private final Font resetButtonFont = returnButtonFont;
    private final Font gameBoardButtonFont = Utils.createBaseFont(Font.BOLD, 50);
    private final int buttonWidth = 100;
    private final int buttonHeight = 100;

    private final Label title = createTitle();
    private final GridBagConstraints titleGridContaints = createTitleConstraints();
    private final Button[][] gameBoardButtons = createGameBoardButtons();
    private final GridBagConstraints[][] gameBoardButtonsConstraints = createGameBoardButtonsConstraints();
    private final Button returnButton = createReturnButton();
    private final GridBagConstraints returnButtonConstraints = createReturnButtonConstraints();

    private final Button resetButton = createResetButton();
    private final GridBagConstraints resetButtonConstraints = createResetButtonConstraints();

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
        startWindow.addComponent(resetButton);
    }

    public void removeComponents() {
        startWindow.removeComponent(title);
        for (Button[] buttonsRow : gameBoardButtons)
            for (Button b : buttonsRow)
                startWindow.removeComponent(b);
        startWindow.removeComponent(returnButton);
        startWindow.removeComponent(resetButton);
    }

    public void clear() {
        title.setText("Tic Tac Toe");
        for (Button[] buttonsRow : gameBoardButtons)
            for (Button button : buttonsRow)
                button.setLabel("");
    }

    private void addConstraints() {
        layout.setConstraints(title, titleGridContaints);
        for (int i = 0; i < TicTacToe.BOARD_SIZE; i++) {
            for (int j = 0; j < TicTacToe.BOARD_SIZE; j++)
                layout.setConstraints(gameBoardButtons[i][j], gameBoardButtonsConstraints[i][j]);
        }
        layout.setConstraints(returnButton, returnButtonConstraints);
        layout.setConstraints(resetButton, resetButtonConstraints);
    }

    private Label createTitle() {
        Label title = new Label("Tic Tac Toe");
        title.setAlignment(Label.CENTER);
        title.setFont(titleFont);

        return title;
    }

    private GridBagConstraints createTitleConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = TicTacToe.BOARD_SIZE;

        return constraints;
    }

    private Button[][] createGameBoardButtons() {
        Button[][] buttons = new Button[TicTacToe.BOARD_SIZE][TicTacToe.BOARD_SIZE];
        for (int i = 0; i < TicTacToe.BOARD_SIZE; i++) {
            Button[] buttonsRow = buttons[i];
            for (int j = 0; j < TicTacToe.BOARD_SIZE; j++) {
                Button b = new Button();
                b.setBackground(Color.GRAY);
                b.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
                b.setFont(gameBoardButtonFont);

                int row = i;
                int col = j;
                b.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (TicTacToe.gameResult() != GameResult.RESUME) return;

                        boolean moved = TicTacToe.move(row, col);
                        if (!moved) return;
                        b.setLabel(TicTacToe.nextMove() == CellState.X ? "O" : "X");

                        GameResult gameResult = TicTacToe.gameResult();
                        if (gameResult == GameResult.TIE) {
                            updateWinLabel("TIE!");
                        } else if (gameResult == GameResult.WIN) {
                            String winner = TicTacToe.nextMove() == CellState.X ? "O" : "X";
                            updateWinLabel(winner + " won!");
                        }
                    }

                    private void updateWinLabel(String text) {
                        title.setText(text);
                        startWindow.pack();
                    }
                });
                buttonsRow[j] = b;
            }
        }

        return buttons;
    }

    private GridBagConstraints[][] createGameBoardButtonsConstraints() {
        GridBagConstraints[][] constraints = new GridBagConstraints[3][3];
        for (int i = 0; i < TicTacToe.BOARD_SIZE; i++) {
            GridBagConstraints[] constraintsRow = constraints[i];
            for (int j = 0; j < TicTacToe.BOARD_SIZE; j++) {
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = j;
                c.gridy = i + 1;
                constraintsRow[j] = c;
            }
        }

        return constraints;
    }

    private Button createReturnButton() {
        Button button = new Button("Return");
        button.addActionListener(e -> TicTacToe.endGame());
        button.setFont(returnButtonFont);

        return button;
    }

    private GridBagConstraints createReturnButtonConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = TicTacToe.BOARD_SIZE + 1;

        return constraints;
    }

    private Button createResetButton() {
        Button button = new Button("Reset");
        button.addActionListener(e -> TicTacToe.resetGame());
        button.setFont(resetButtonFont);

        return button;
    }

    private GridBagConstraints createResetButtonConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 2;
        constraints.gridy = TicTacToe.BOARD_SIZE + 1;

        return constraints;
    }
}
