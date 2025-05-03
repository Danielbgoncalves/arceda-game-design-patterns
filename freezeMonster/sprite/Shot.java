package freezeMonster.sprite;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;

import java.util.Objects;


public class Shot extends BadSprite {
    private String direction;

    public Shot(){
    }

    public Shot(int x, int y) {

        initShot(x, y);
    }

    private void initShot(int x, int y) {

        String shotImg = "images/shot.png";
        ImageIcon ii = new ImageIcon(shotImg);
        setImage(ii.getImage());

        int H_SPACE = 6;
        setX(x + H_SPACE);

        int V_SPACE = 1;
        setY(y - V_SPACE);
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void updatePosition(){
        int x = getX();
        int y = getY();

        if(Objects.equals(direction, "left")){
            x -= 4;
        } else if(Objects.equals(direction, "right")){
            x += 4;
        } else if(Objects.equals(direction, "down")){
            y += 4;
        } else {
            y -= 4;
        }

        setY(y);
        setX(x);

        // System.out.println("Tiro atualizado");

        if (y < 0 || y > 350 || x < 0 || x > 358) {
            die();
        }
    }

}
