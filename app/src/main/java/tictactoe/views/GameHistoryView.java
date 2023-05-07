package tictactoe.views;

import tictactoe.Utils;
import tictactoe.models.GameHistoryModel;

import java.awt.*;
import java.awt.event.WindowEvent;

public class GameHistoryView extends Alert {
    private final GameHistoryModel gameHistoryModel;

    private final TextArea gameHistoryText;

    public GameHistoryView(GameHistoryModel historyModel) {
        setTitle("Game History");
        this.gameHistoryModel = historyModel;
        this.gameHistoryText = new TextArea();
        setLayout(new GridLayout(1, 1));
        setSize(300, 500);
        setLocationRelativeTo(null);
        addWindowListener(this);
    }

    public void showHistory() {
        String history = gameHistoryModel.getGameHistory();
        gameHistoryText.setEditable(false);
        gameHistoryText.setText(history);
        gameHistoryText.setFont(Utils.createBaseFont(Font.PLAIN, 15));
        add(gameHistoryText);
        setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        setVisible(false);
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        setVisible(false);
    }
}
