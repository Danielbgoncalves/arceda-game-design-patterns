package freezeMonster.sprite;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;
import spriteframework.sprite.ScaleImage;

import java.util.Objects;


public class Shot extends BadSprite {
    private String direction;

    public Shot(){
    }

    public Shot(String loc, int x, int y, int larg, int alt) {

        initShot(loc, x, y, larg, alt);
    }

    private void initShot(String loc, int x, int y, int larg, int alt) {

        ScaleImage scaledImage = new ScaleImage(loc, larg, alt);
        ImageIcon ii = scaledImage.getScaledImage();
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
            x -= 6;
        } else if(Objects.equals(direction, "right")){
            x += 6;
        } else if(Objects.equals(direction, "down")){
            y += 6;
        } else {
            y -= 6;
        }

        setY(y);
        setX(x);

        /// colocar commons posteriormente na framework
        if (y < 0 || y > 600 || x < 0 || x > 600) {
            die();
        }
    }

}
