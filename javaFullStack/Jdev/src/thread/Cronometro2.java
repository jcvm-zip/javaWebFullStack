package thread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Cronometro2 extends JPanel implements ActionListener {
    private JLabel display;
    private Timer timer;
    private int count;

    public Cronometro2() {
        setLayout(new BorderLayout());

        display = new JLabel("0");
        display.setFont(new Font("Serif", Font.BOLD, 24));
        add(display, BorderLayout.CENTER);

        timer = new Timer(1000, this);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        count++;
        display.setText(Integer.toString(count));
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Cronômetro");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Cronometro2());
        frame.pack();
        frame.setVisible(true);
    }
}
