package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class KeyListener implements java.awt.event.KeyListener {

    boolean inConsole = false;
    String consoleMsg;

    public Panel panel;

    public KeyListener(Panel panel) {
        this.panel = panel;
    }

    public Main main = new Main();

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_BACK_SPACE && inConsole) {
            panel.stringBackspace();
            return;
        }
        if (inConsole) {
            System.out.println("print");
            panel.addString(String.valueOf(e.getKeyChar()));
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode()==KeyEvent.VK_ESCAPE) {
            if (!inConsole) {
                main.closeFrame();
            } else {
                inConsole = false;
                panel.resetConsoleString();
                panel.repaint();
            }
        }

        if (e.getKeyCode()==KeyEvent.VK_0 && !inConsole) {
            panel.addString(">");
            inConsole = true;
        }
        if (inConsole) {
            return;
        }
        if (e.getKeyCode()==KeyEvent.VK_F1) {
            if (panel.getColor("wall").equals(Color.BLACK)) {
                panel.setColors("wall", Color.WHITE);
                panel.setColors("air",Color.BLACK);
                panel.setColors("msg",Color.WHITE);
                panel.repaint();
                return;
            }
            if (panel.getColor("wall").equals(Color.WHITE)) {
                panel.setColors("wall", Color.BLACK);
                panel.setColors("air",Color.WHITE);
                panel.setColors("msg",Color.BLACK);
                panel.repaint();
                return;
            }
        }
        if (e.getKeyCode()==KeyEvent.VK_LEFT || e.getKeyCode()==KeyEvent.VK_A) {
            panel.moveLeft();
        }
        if (e.getKeyCode()==KeyEvent.VK_RIGHT || e.getKeyCode()==KeyEvent.VK_D) {
            panel.moveRight();
        }
        if (e.getKeyCode()==KeyEvent.VK_UP || e.getKeyCode()==KeyEvent.VK_W) {
            panel.moveUp();
        }
        if (e.getKeyCode()==KeyEvent.VK_DOWN || e.getKeyCode()==KeyEvent.VK_S) {
            panel.moveDown();
        }
    }
}
