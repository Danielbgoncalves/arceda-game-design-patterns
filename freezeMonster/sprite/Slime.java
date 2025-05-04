package freezeMonster.sprite;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;
import spriteframework.sprite.ScaleImage;

public class Slime extends BadSprite {

    private boolean destroyed;

    public Slime(String loc, int x, int y, int larg, int alt) {

        initSlime(loc,x, y, larg, alt);
    }

    private void initSlime(String loc, int x, int y, int larg, int alt) {

        setDestroyed(true);

        this.x = x;
        this.y = y;

        ScaleImage scaledImage = new ScaleImage(loc, larg, alt);
        ImageIcon ii = scaledImage.getScaledImage();
        setImage(ii.getImage());
    }

    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {

        return destroyed;
    }
    
    
}
