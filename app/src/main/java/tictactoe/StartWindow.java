package tictactoe;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class StartWindow {
    private final Frame frame = new Frame("Tic Tac Toe");
    private int width;
    private int height;

    public StartWindow() {
        updateSize();
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {}

            @Override
            public void windowClosing(WindowEvent e) {
                TicTacToe.exit();
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

    public void show() {
        TicTacToe.showMainMenu();
        frame.setVisible(true);
    }

    public void end() {
        frame.dispose();
    }

    public void addComponent(Component component) {
        frame.add(component);
        pack();
    }

    public void removeComponent(Component component) {
        frame.remove(component);
        pack();
    }

    public void setLayout(LayoutManager mgr) {
        frame.setLayout(mgr);
    }

    public void pack() {
        frame.pack();
        frame.setSize(width, height);
    }

    public void updateSize() {
        width = height = (TicTacToe.BOARD_SIZE + 2) * 100;
    }
}
