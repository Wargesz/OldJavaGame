package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Panel extends JPanel {

    private Rectangle target = new Rectangle(420,40,60,30);
    private Rectangle mover = new Rectangle(40,240,1,1);


    @Override
    public void paint(Graphics g) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("lib/img/hero.png"));
        } catch (IOException e) {}
        g.setColor(Color.WHITE);
        g.fillRect(1,1,1000,1000);
        g.drawImage(img,mover.x,mover.y,null);
        g.setColor(Color.BLUE);
        g.fillRect(target.x,target.y,target.width,target.height);
        g.setColor(Color.ORANGE);
        g.fillRect(mover.x,mover.y,mover.width,mover.height);
    }

    public void moveLeft() {
        mover.x-=5;
        this.repaint();
    }
    public void moveRight() {
        mover.x+=5;
        this.repaint();
    }
    public void moveUp() {
        mover.y-=5;
        this.repaint();
    }
    public void moveDown() {
        mover.y+=5;
        this.repaint();
    }
    public void setLoc(Integer x,Integer y) {
        mover.x += x;
        mover.y += y;
        this.repaint();
    }
}
