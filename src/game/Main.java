package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main{

    static Panel panel = new Panel();
    static JFrame frame = new JFrame();
    static Dimension d = new Dimension();

    public static void main(String[] args) {
        d.setSize(680,690);
        frame = new JFrame();
        panel = new Panel();
        panel.setColors("wall",Color.BLACK);
        panel.setColors("air",Color.WHITE);
        panel.setColors("msg",Color.BLACK);
        panel.setFocusable(true);
        panel.addKeyListener(new KeyListener(panel));
        frame.getContentPane().add(panel);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(d);
        frame.setResizable(true);
        frame.setVisible(true);
    }

    public Panel getPanel() {return panel;}

    public void addToFrame(Component c) {
        frame.add(c);
    }

    public void closeFrame() {
        frame.dispose();
    }
}