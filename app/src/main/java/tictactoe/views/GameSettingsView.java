package tictactoe.views;

import tictactoe.Utils;
import tictactoe.controllers.MainController;
import tictactoe.models.GameBoardModel;

import javax.swing.*;
import java.awt.*;

public class GameSettingsView {
    private final MainView mainView;

    private final Label hintLabel;
    private final Button[] changeSizeButtons;

    public GameSettingsView(MainView mainView) {
        this.mainView = mainView;
        this.hintLabel = createHintLabel();
        this.changeSizeButtons = createChangeSizeButtons();
    }

    public void addComponents() {
        mainView.setLayout(new GridLayout(0, 1));
        mainView.addComponent(hintLabel);
        for (Button button : changeSizeButtons)
            mainView.addComponent(button);
    }

    public void removeComponents() {
        mainView.removeComponent(hintLabel);
        for (Button button : changeSizeButtons)
            mainView.removeComponent(button);
    }

    private Label createHintLabel() {
        Label hint = new Label("Choose Game Board Size");
        hint.setAlignment(Label.CENTER);
        hint.setFont(Utils.createBaseFont(Font.BOLD, 30));

        return hint;
    }

    private Button[] createChangeSizeButtons() {
        int minSize = GameBoardModel.MIN_SIZE;
        int maxSize = GameBoardModel.MAX_SIZE;
        Button[] buttons = new Button[maxSize - minSize + 1];
        for (int i = minSize; i <= maxSize; i++) {
            Button b = new Button(i + "x" + i);

            b.setFont(Utils.createBaseFont(Font.BOLD, 30));
            b.setActionCommand(ActionCommand.CHANGE_SIZE.toString());
            b.addActionListener(mainView);

            buttons[i - minSize] = b;
        }

        return buttons;
    }
}
