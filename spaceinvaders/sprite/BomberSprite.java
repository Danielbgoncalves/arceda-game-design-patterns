package spaceinvaders.sprite;

import java.util.Iterator;
import java.util.LinkedList;

import javax.swing.ImageIcon;
import spriteframework.Commons;
import spriteframework.sprite.BadSprite;
import spriteframework.sprite.BadnessBoxSprite;
import spriteframework.sprite.ScaleImage;

public class BomberSprite extends BadnessBoxSprite {

    private Bomb bomb;

    public BomberSprite(String path, int x, int y, int larg, int alt) {

        initBomber(path,x, y, larg, alt);
    }

    private void initBomber(String path, int x, int y , int larg, int alt) {

        this.x = x;
        this.y = y;

        bomb = new Bomb(x, y);

        ScaleImage scaledImage = new ScaleImage(path,  larg, alt);
        ImageIcon ii = scaledImage.getScaledImage();

        setImage(ii.getImage());
    }




    public Bomb getBomb() {

        return bomb;
    }


	@Override
	public LinkedList<BadSprite> getBadnesses() {
		LinkedList<BadSprite> aBomb = new LinkedList<BadSprite>();
		aBomb.add(bomb);
		return aBomb;
	}

    /*public  void initMovimentation(){
        int x = getX();

        if (x >= Commons.BOARD_WIDTH - Commons.BORDER_RIGHT && direction != -1) {

            direction = -1;

            Iterator<BadSprite> i1 = badSprites.iterator();

            while (i1.hasNext()) {
                BadSprite a2 = i1.next();
                a2.setY(a2.getY() + Commons.GO_DOWN);
            }
        }

        if (x <= Commons.BORDER_LEFT && direction != 1) {

            direction = 1;

            Iterator<BadSprite> i2 = badSprites.iterator();

            while (i2.hasNext()) {

                BadSprite a = i2.next();
                a.setY(a.getY() + Commons.GO_DOWN);
            }
        }
    }

    Iterator<BadSprite> it = badSprites.iterator();

    // verifica condição de derrota
        while (it.hasNext()) {

        BadSprite monster = it.next();

        if (monster.isVisible()) {

            int y = monster.getY();

            if (y > Commons.GROUND - Commons.MONSTER_HEIGHT) {
                inGame = false;
                message = "Invasion!";
            }

            monster.moveX(direction);
        }
    }*/
}
