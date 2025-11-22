package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * A very simple program using a graphical interface.
 *
 */
public final class SimpleGUI {

    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();
    private final Controller controller;

    /**
     * simple GUI.
     * 
     * @param controller new controller.
     */

    @SuppressFBWarnings(
        value = "EI_EXPOSE_REP2",
        justification = "The controller is designed to be manipulated this way."
    )
    public SimpleGUI(final Controller controller) {
        this.controller = controller;
        final JPanel canvas = new JPanel(new BorderLayout());
        final JTextField inputText = new JTextField("Enter string here...");
        final JTextArea historytext = new JTextArea("History will appear here");
        historytext.setEditable(false);
        final JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
        final JButton print = new JButton("Print");
        final JButton showHistory = new JButton("Show history");

        panel.add(print);
        panel.add(showHistory);
        canvas.add(inputText, BorderLayout.NORTH);
        canvas.add(historytext, BorderLayout.CENTER);
        canvas.add(panel, BorderLayout.SOUTH);

        frame.setContentPane(canvas);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        print.addActionListener(
                new ActionListener() {
                @Override
                public void actionPerformed(final ActionEvent e) {
                    SimpleGUI.this.controller.setNextString(inputText.getText());
                    SimpleGUI.this.controller.printString();
                }
            }
        );

        showHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                final List<String> history = controller.getPrintStringHistroy();
                final String historyText;
                if (history.isEmpty()) {
                    historyText = "no print string yet";
                } else {
                    historyText = String.join("\n", history);
                }
                historytext.setText(historyText);
                }
            }
        );
    }

    private void display() {
        final int width = SCREEN_SIZE.width / PROPORTION;
        final int height = SCREEN_SIZE.height / PROPORTION;
        frame.setSize(width, height);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * simple main.
     * 
     * @param args args of the main.
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
