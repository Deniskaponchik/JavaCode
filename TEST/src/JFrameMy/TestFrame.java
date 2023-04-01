package JFrameMy;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestFrame extends JFrame {

    private JLabel eventLabel;

    public TestFrame() {
        super("Test frame");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel buttonsPanel = new JPanel();

        JButton button1 = new JButton("Button 1");
        button1.setPreferredSize(new Dimension(150, 80));
        buttonsPanel.add(button1);

        JButton button2 = new JButton("Button 2");
        button2.setPreferredSize(new Dimension(150, 80));
        buttonsPanel.add(button2);

        button2.addFocusListener(new CustomListener());

        mainPanel.add(buttonsPanel, BorderLayout.NORTH);

        eventLabel = new JLabel();
        eventLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(eventLabel, BorderLayout.CENTER);

        getContentPane().add(mainPanel);
    }

    public static JLabel createEmptyLabel() {
        JLabel label = new JLabel();
        label.setPreferredSize(new Dimension(100, 30));
        return label;
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JFrame frame = new TestFrame();
                frame.setPreferredSize(new Dimension(330, 160));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class CustomListener implements FocusListener {

        public void focusGained(FocusEvent e) {
            eventLabel.setText("Button 2 — focusGained()");
        }

        public void focusLost(FocusEvent e) {
            eventLabel.setText("Button 2 — focusLost()");
        }
    }
}