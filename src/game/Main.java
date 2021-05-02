package game;

import javax.swing.*;
import java.awt.*;

public class Main{

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Panel panel = new Panel();
        panel.setFocusable(true);
        panel.addKeyListener(new KeyListener(panel));
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(640,420);
        frame.setVisible(true);
    }
}