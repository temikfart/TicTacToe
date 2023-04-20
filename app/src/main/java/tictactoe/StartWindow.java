package tictactoe;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class StartWindow {
    private final Frame frame = new Frame("Tic Tac Toe");

    StartWindow() {
        setupFrame();
    }

    public void show() {
        frame.setVisible(true);
    }

    private void setupFrame() {
        frame.setLayout(new GridLayout());
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
}
