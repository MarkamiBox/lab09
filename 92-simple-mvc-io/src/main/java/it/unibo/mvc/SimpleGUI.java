package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A very simple program using a graphical interface.
 */
public final class SimpleGUI {
    private static final String TITLE = "My first java graphical interface";
    private final JFrame frame = new JFrame(TITLE);

    /**
     * Builder of the GUI.
     * 
     * @param controller new controller
     */
    public SimpleGUI(final Controller controller) {
        final JPanel panel = new JPanel();
        final JTextArea textArea = new JTextArea();
        final JButton save = new JButton("Save");

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent ignored) {
                try (PrintStream ps = new PrintStream(controller.getPath(), StandardCharsets.UTF_8)) {
                    ps.print(textArea.getText());
                } catch (final IOException e) {
                    JOptionPane.showMessageDialog(frame, e, "Error", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace(); // NOPMD: allowed as this is just an exercise
                }
            }
        });
        panel.setLayout(new BorderLayout());
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(save, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Display of the GUI.
     */
    private void display() {
        final int value = 5;
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / value, sh / value);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Main.
     * 
     * @param args args
     */
    public static void main(final String[] args) {
        new SimpleGUI(new Controller()).display();
    }
}
