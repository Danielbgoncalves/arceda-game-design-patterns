package freezeMonster.sprite;

import javax.swing.ImageIcon;

import spriteframework.sprite.BadSprite;

public class Slime extends BadSprite {

    private boolean destroyed;

    public Slime(int x, int y) {

        initSlime(x, y);
    }

    private void initSlime(int x, int y) {

        setDestroyed(true);

        this.x = x;
        this.y = y;

        String slimeImg = "images/bomb.png";
        ImageIcon ii = new ImageIcon(slimeImg);
        setImage(ii.getImage());
    }

    public void setDestroyed(boolean destroyed) {

        this.destroyed = destroyed;
    }

    public boolean isDestroyed() {

        return destroyed;
    }
    
    
}
