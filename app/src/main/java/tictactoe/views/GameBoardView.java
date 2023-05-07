package tictactoe.views;

import tictactoe.Utils;
import tictactoe.models.GameBoardModel;

import java.awt.*;

public class GameBoardView {
    private final MainView mainView;

    private final Label title;
    private Button[][] gameBoardButtons;
    private final Button returnButton;
    private final Button historyButton;
    private final Button resetButton;

    private GridBagConstraints titleGridConstraints;
    private GridBagConstraints[][] gameBoardButtonsConstraints;
    private GridBagConstraints returnButtonConstraints;
    private GridBagConstraints historyButtonConstraints;
    private GridBagConstraints resetButtonConstraints;

    private final Font actionButtonsFont = Utils.createBaseFont(Font.BOLD, 17);

    public GameBoardView(MainView mainView) {
        this.mainView = mainView;

        this.title = createTitle();
        this.gameBoardButtons = createGameBoardButtons();
        this.returnButton = createReturnButton();
        this.historyButton = createHistoryButton();
        this.resetButton = createResetButton();

        createConstraints();
    }

    public void reset() {
        removeComponents();
        if (gameBoardButtons.length == GameBoardModel.BOARD_SIZE) {
            for (Button[] buttonsRow : gameBoardButtons)
                for (Button b : buttonsRow)
                    b.setLabel("");
        } else {
            gameBoardButtons = createGameBoardButtons();
            createConstraints();
        }
        addComponents();
    }

    public void addComponents() {
        GridBagLayout layout = new GridBagLayout();
        mainView.setLayout(layout);

        layout.setConstraints(title, titleGridConstraints);
        for (int i = 0; i < GameBoardModel.BOARD_SIZE; i++)
            for (int j = 0; j < GameBoardModel.BOARD_SIZE; j++)
                ((GridBagLayout) mainView.getLayout()).setConstraints(gameBoardButtons[i][j],
                        gameBoardButtonsConstraints[i][j]);
        layout.setConstraints(returnButton, returnButtonConstraints);
        layout.setConstraints(historyButton, historyButtonConstraints);
        layout.setConstraints(resetButton, resetButtonConstraints);

        mainView.addComponent(title);
        for (Button[] buttonsRow : gameBoardButtons)
            for (Button b : buttonsRow)
                mainView.addComponent(b);
        mainView.addComponent(returnButton);
        mainView.addComponent(historyButton);
        mainView.addComponent(resetButton);
    }

    private void createConstraints() {
        this.titleGridConstraints = createTitleConstraints();
        this.gameBoardButtonsConstraints = createGameBoardButtonsConstraints();
        this.returnButtonConstraints = createReturnButtonConstraints();
        this.historyButtonConstraints = createHistoryButtonConstraints();
        this.resetButtonConstraints = createResetButtonConstraints();
    }

    public void removeComponents() {
        mainView.removeComponent(title);
        for (Button[] buttonsRow : gameBoardButtons)
            for (Button b : buttonsRow)
                mainView.removeComponent(b);
        mainView.removeComponent(returnButton);
        mainView.removeComponent(historyButton);
        mainView.removeComponent(resetButton);
    }

    private Label createTitle() {
        Label title = new Label("Tic Tac Toe");
        title.setAlignment(Label.CENTER);
        title.setFont(Utils.createBaseFont(Font.BOLD, 30));

        return title;
    }

    private Button[][] createGameBoardButtons() {
        Button[][] buttons = new Button[GameBoardModel.BOARD_SIZE][GameBoardModel.BOARD_SIZE];
        for (int i = 0; i < GameBoardModel.BOARD_SIZE; i++) {
            Button[] buttonsRow = buttons[i];
            for (int j = 0; j < GameBoardModel.BOARD_SIZE; j++) {
                Button b = new Button("");

                b.setBackground(Color.GRAY);
                b.setFont(Utils.createBaseFont(Font.BOLD, 50));
                b.setPreferredSize(new Dimension(100, 100));

                b.setName(i + "," + j);
                b.setActionCommand(ActionCommand.MOVE.toString());
                b.addActionListener(mainView);

                buttonsRow[j] = b;
            }
        }

        return buttons;
    }

    private Button createReturnButton() {
        Button button = new Button("Return");
        button.setFont(actionButtonsFont);
        button.setActionCommand(ActionCommand.RETURN.toString());
        button.addActionListener(mainView);

        return button;
    }

    private Button createHistoryButton() {
        Button button = new Button("History");
        button.setFont(actionButtonsFont);
        button.setActionCommand(ActionCommand.SHOW_HISTORY.toString());
        button.addActionListener(mainView);

        return button;
    }

    private Button createResetButton() {
        Button button = new Button("Reset");
        button.setFont(actionButtonsFont);
        button.setActionCommand(ActionCommand.RESET.toString());
        button.addActionListener(mainView);

        return button;
    }

    private GridBagConstraints createTitleConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GameBoardModel.BOARD_SIZE;

        return constraints;
    }

    private GridBagConstraints[][] createGameBoardButtonsConstraints() {
        int boardSize = GameBoardModel.BOARD_SIZE;
        GridBagConstraints[][] constraints = new GridBagConstraints[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            GridBagConstraints[] constraintsRow = constraints[i];
            for (int j = 0; j < boardSize; j++) {
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = j;
                c.gridy = i + 1;
                constraintsRow[j] = c;
            }
        }

        return constraints;
    }

    private GridBagConstraints createReturnButtonConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = GameBoardModel.BOARD_SIZE + 1;

        return constraints;
    }

    private GridBagConstraints createHistoryButtonConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 1;
        constraints.gridy = GameBoardModel.BOARD_SIZE + 1;

        return constraints;
    }

    private GridBagConstraints createResetButtonConstraints() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = GameBoardModel.BOARD_SIZE - 1;
        constraints.gridy = GameBoardModel.BOARD_SIZE + 1;

        return constraints;
    }
}
