package game;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class KeyListener implements java.awt.event.KeyListener {

    public Panel panel;

    List<Integer> keys = new ArrayList();

    public KeyListener(Panel panel) {
        this.panel = panel;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keys.contains(e.getKeyCode())) {
            for (int i = 0;i < keys.size();i++) {
                if (keys.get(i).equals(e.getKeyCode())) {
                    keys.remove(i);
                    break;
                }
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keys.contains(e.getKeyCode())) {
            keys.add(e.getKeyCode());
        }
        if (keys.contains(87) && keys.contains(68)) {
            panel.setLoc(5,-5);
            return;
        }
        //up left
        if (keys.contains(87) && keys.contains(65)) {
            panel.setLoc(-5,-5);
            return;
        }
        //down right
        if (keys.contains(83) && keys.contains(68)) {
            panel.setLoc(5,5);
            return;
        }
        //down left
        if (keys.contains(83) && keys.contains(65)) {
            panel.setLoc(-5,5);
            return;
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
