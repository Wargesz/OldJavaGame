package game;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Panel extends JPanel {

    private Rectangle target = new Rectangle(420,40,20,20);
    private Rectangle mover = new Rectangle(1,300,20,20);
    boolean noCanGo = false;
    boolean devView = true;
    boolean addConsole = false;
    Main main = new Main();
    KeyListener keyListener = new KeyListener(main.getPanel());
    Font font = new Font ("Consolas", 1, 17);
    GameCharacter hero = new GameCharacter();
    List<Integer> wallList = Arrays.asList(95,96,97,98,118,137,150,168,185,308);
    List<Integer> enemyList = Arrays.asList(47);
    HashMap<String,Color> colorMap = new HashMap<>();
    String consoleString = "";

    public void setColors(String key,Color clr) {
        colorMap.put(key,clr);
    }
    public Color getColor(String key) {
        return colorMap.get(key);
    }

    @Override
    public void paint(Graphics g) {
        if (!devView) {
            BufferedImage img = null;
            try {
                img = ImageIO.read(new File("lib/img/hero.png"));
            } catch (IOException e) {}
            g.setColor(Color.GRAY);
            g.fillRect(1,1,main.getPanel().getWidth(),main.getPanel().getHeight());
        }
        if (devView) {
            g.setColor(Color.GRAY);
            g.fillRect(1,1,main.getPanel().getWidth(),main.getPanel().getHeight());
            g.setColor(colorMap.get("air"));
            g.fillRect(1,1,680,690);
            int i = 0;
            int o = 0;
            int counter = 0;
            for (i = 0; i < 640/32;i++) {
                for (o = 0; o < 640/32;o++) {
                    if (wallList.contains(counter)) {
                        g.setColor(colorMap.get("wall"));
                        g.fillRect(o*32,i*32,32,32);
                    } else if (enemyList.contains(counter)) {
                        g.setColor(Color.RED);
                        g.fillRect(o*32,i*32,32,32);
                    } else {
                        g.setColor(colorMap.get("air"));
                        g.fillRect(o*32,i*32,32,32);
                    }
                    counter++;
                }
            }
            g.setColor(Color.BLUE);
            g.fillRect(hero.getPosX()*32,hero.getPosY()*32,32,32);
            g.setColor(colorMap.get("msg"));
            g.setFont(font);
            g.drawString("h:"+(i-1)+",w:"+(o-1),5,20);
            g.drawString("h:"+hero.getPosX()+",w:"+hero.getPosY(),5,40);
            if (noCanGo) {
                g.drawString("you can't go there",5,60);
                noCanGo = false;
            }
            if (addConsole) {
                g.drawString(consoleString,5,600);
                addConsole = false;
            }
        }
    }

    public void moveLeft() {
        hero.posX-=1;
        if (wallList.contains((hero.posY-1)*20+hero.posX+20)) {
            hero.posX+=1;
            noCanGo = true;
        }
        if (hero.getPosX()<0) {
            hero.posX+=1;
        }
        this.repaint();
    }
    public void moveRight() {
        hero.posX+=1;
        if (wallList.contains((hero.posY-1)*20+hero.posX+20)) {
            hero.posX-=1;
            noCanGo = true;
        }
        if (hero.getPosX()>640/32-1) {
            hero.posX-=1;
        }
        this.repaint();
    }
    public void moveUp() {
        hero.posY-=1;
        if (wallList.contains((hero.posY)*20+hero.posX)) {
            hero.posY+=1;
            noCanGo = true;
        }
        if (hero.getPosY()<0) {
            hero.posY+=1;
        }
        this.repaint();
    }
    public void moveDown() {
        hero.posY+=1;
        if (wallList.contains((hero.posY)*20+hero.posX)) {
            hero.posY-=1;
            noCanGo = true;
        }
        if (hero.getPosY()>640/32-1) {
            hero.posY-=1;
        }
        this.repaint();
    }
    public void setLoc(Integer x,Integer y) {
        hero.posX+=x;
        hero.posY+=y;
        this.repaint();
    }
    public void moved(String move) {
        if (mover.intersects(target)) {
            switch (move) {
                case "left":
                    mover.x+=5;
                    break;
                case "right":
                    mover.x-=5;
                    break;
                case "up":
                    mover.x+=5;
                    break;
                case "down":
                    mover.x-=5;
                    break;
            }
            noCanGo = true;
        }
    }
    public void addString(String s) {
        addConsole = true;
        consoleString+= s;
        this.repaint();
    }
    public void stringBackspace() {
        if (consoleString.length()>1) {
            addConsole = true;
            System.out.println("start:"+consoleString);
            consoleString = consoleString.substring(0,consoleString.length()-2);
            System.out.println("edited:"+consoleString);
            this.repaint();
        } else {
            System.out.println("nothing to delete");
            addConsole = true;
        }
    }
    public void resetConsoleString() {
        consoleString = "";
    }
}
