package tictactoe;

import tictactoe.controllers.MainMenuController;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class StartWindow {

    private final Frame frame = new Frame("Tic Tac Toe");
    private final MainMenuController mainMenuController = new MainMenuController(this);

    public StartWindow() {
        setupFrame();
    }

    public void show() {
        showMainMenu();
        frame.setVisible(true);
    }

    private void setupFrame() {
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                frame.dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {}

            @Override
            public void windowIconified(WindowEvent e) {}

            @Override
            public void windowDeiconified(WindowEvent e) {}

            @Override
            public void windowActivated(WindowEvent e) {}

            @Override
            public void windowDeactivated(WindowEvent e) {}
        });
    }

    public void addComponent(Component component) {
        frame.add(component);
    }

    public void end() {
        frame.dispose();
    }

    public void showMainMenu() {
        mainMenuController.show();
    }

    public void hideMainMenu() {
        mainMenuController.hide();
    }
}
