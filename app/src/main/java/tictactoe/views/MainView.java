package tictactoe.views;

import tictactoe.Utils;
import tictactoe.controllers.MainController;
import tictactoe.models.CellState;
import tictactoe.models.GameBoardModel;
import tictactoe.models.GameResult;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Arrays;

public class MainView extends Frame implements WindowListener, ActionListener {
    private int width;
    private int height;

    public MainView() {
        super("Tic Tac Toe");

        addWindowListener(this);
        updateSize(GameBoardModel.MIN_SIZE);
        setLocationRelativeTo(null);
    }

    public void showWindow() {
        MainController.mainMenuController.show();
        setVisible(true);
    }

    public void addComponent(Component component) {
        add(component);
        repaintWindow();
    }

    public void removeComponent(Component component) {
        remove(component);
        repaintWindow();
    }

    public void repaintWindow() {
        pack();
        setSize(width, height);
        setLocationRelativeTo(null);
    }

    public void updateSize(int newSize) {
        GameBoardModel.BOARD_SIZE = newSize;
        width = height = (newSize + 2) * 100;
        repaintWindow();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Button button = (Button) e.getSource();
        ActionCommand cmd = ActionCommand.resolve(button.getActionCommand());
        switch(cmd) {
            case EXIT -> MainController.exit();
            case START_GAME -> {
                MainController.mainMenuController.hide();
                MainController.gameSettingsController.show();
            }
            case RETURN -> MainController.gameBoardController.endGame();
            case SHOW_HISTORY -> MainController.gameHistoryController.show();
            case RESET -> MainController.gameBoardController.startGame();
            case CHANGE_SIZE -> {
                updateSize(Character.getNumericValue(button.getLabel().charAt(0)));
                MainController.gameBoardController.startGame();
            }
            case MOVE -> {
                if (MainController.gameBoardController.gameResult() != GameResult.RESUME) return;

                int[] coords = Arrays.stream(button.getName().split(","))
                         .mapToInt(Integer::parseInt).toArray();
                boolean moved = MainController.gameBoardController.move(coords[0], coords[1]);
                if (!moved) return;
                button.setLabel(MainController.gameBoardController.nextMove() == CellState.X ? "O" : "X");

                GameResult gameResult = MainController.gameBoardController.gameResult();
                if (gameResult == GameResult.TIE) {
                    String text = "TIE!";
                    showGameResultAlert(text);
                    MainController.gameHistoryController.saveGaveResult(text);
                } else if (gameResult == GameResult.WIN) {
                    String winner = MainController.gameBoardController.nextMove() == CellState.X ? "O" : "X";
                    String text = winner + " won!";
                    showGameResultAlert(text);
                    MainController.gameHistoryController.saveGaveResult(text);
                }
            }
        }
        repaint();
    }

    private void showGameResultAlert(String text) {
        Alert alert = new Alert();
        alert.setTitle("Game Result");
        alert.setLayout(new GridLayout(2, 1));
        alert.setSize(300, 200);

        alert.add(createGameResultLabel(text));
        Button okButton = createOkButton();
        okButton.addActionListener(e -> alert.dispose());
        alert.add(okButton);

        alert.addWindowListener(alert);
        alert.setLocationRelativeTo(null);
        alert.setVisible(true);
    }

    private Button createOkButton() {
        Button button = new Button("OK");
        button.setPreferredSize(new Dimension(40, 15));
        button.setMaximumSize(new Dimension(40, 15));
        button.setFont(Utils.createBaseFont(Font.BOLD, 20));

        return button;
    }

    private Label createGameResultLabel(String text) {
        Label label = new Label(text);
        label.setPreferredSize(new Dimension(100, 30));
        label.setFont(Utils.createBaseFont(Font.PLAIN, 30));
        label.setAlignment(Label.CENTER);

        return label;
    }

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowClosing(WindowEvent e) {
        MainController.exit();
    }

    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {
        this.setEnabled(true);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        this.setEnabled(false);
    }
}
