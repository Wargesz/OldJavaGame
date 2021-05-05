package game;

import java.util.ArrayList;
import java.util.List;

public class GameCharacter {
    Integer posX = 0;
    Integer posY = 0;
    List<String> imgPathList = new ArrayList<>();

    public Integer getPosX() {
        return posX;
    }
    public Integer getPosY() {
        return posY;
    }
    public void setPosX(Integer x) {
        this.posX=x;
    }
    public void setPosY(Integer y) {
        this.posY=y;
    }
}
